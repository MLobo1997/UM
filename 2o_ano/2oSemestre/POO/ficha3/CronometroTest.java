public class CronometroTest{
    public static void main(String [] argc){
        CronometroDS test = new CronometroDS();
        test.inicia();
            try {
                Thread.sleep(6780,333);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        System.out.println("UM JA TA CRL");
        test.parar();

            try {
                Thread.sleep(2340,141);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        test.parar();

        System.out.println(test.primeiraParagem());
        System.out.println(test.segundaParagem());
        System.out.println(test.tempoSplit());
        System.out.println(test.tempoAbsoluto());
    }
}
