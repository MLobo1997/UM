package Guiao5;

import java.time.Duration;
import java.time.Instant;

public class Main5 {

    public static void main(String[] argv){
        BoundedBuffer5 b;
        int cI, pI, cNr, pNr, cG = 0, pG = 0;
        final int total = 1000000000;
        int toPut, toGet, toGetRest, toPutRest;

        Thread c[];
        Thread p[];
        Thread s;

        Duration thisDuration, bestDuration =  Duration.ofDays(1);
        Instant start, end;

        for(cNr = 1 ; cNr <= 5 ; cNr++){
            for(pNr = 1 ; pNr <= 5 ; pNr++){
                System.out.println("Test: c = " + cNr + "  p = " + pNr);

                b = new BoundedBuffer5(1000);
                c = new Thread[cNr];
                p = new Thread[pNr];

                toGet = total / cNr;
                toPut = total / pNr;
                toGetRest = total % cNr;
                toPutRest = total % pNr;

                if((toGet * cNr)+toGetRest != (toPut * pNr)+toPutRest)
                    System.out.println("SAO DIFERENTES MEU");


                for(cI = 0 ; cI < (cNr-1) ; cI++)
                    c[cI] = new Thread(new Consumer5(b, toGet));
                c[cI] = new Thread(new Consumer5(b, toGet + toGetRest));

                for(pI = 0 ; pI < (pNr-1) ; pI++)
                    p[pI] = new Thread(new Inserter5(b, toPut));
                p[pI] = new Thread(new Inserter5(b, toPut + toPutRest));

                start = Instant.now();

                for(cI = 0 ; cI < cNr ; cI++)
                    c[cI].start();
                for(pI = 0 ; pI < pNr ; pI++)
                    p[pI].start();

                try {
                    for(cI = 0 ; cI < cNr ; cI++)
                        c[cI].join();

                    for(pI = 0 ; pI < pNr ; pI++)
                        p[pI].join();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }

                end = Instant.now();
                thisDuration = Duration.between(start, end);
                System.out.println("This case lasted: " + thisDuration);

                if(thisDuration.compareTo(bestDuration) < 0){
                    bestDuration = thisDuration;
                    cG = cNr;
                    pG = pNr;
                    System.out.println("WE GOT A RECORD!!!");
                }

            }
        }

        System.out.println("\n\nIdeal: c -> " + cG + "     p -> " + pG + " with: " + bestDuration);
    }
}
