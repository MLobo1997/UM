import java.time.Instant;
import java.time.Duration;

public class CronometroDS{
    private Instant init;
    private Duration fst;
    private Duration snd;

    public CronometroDS(){
        this.init = Instant.EPOCH;
        this.fst = Duration.ZERO;
        this.snd = Duration.ZERO;
    }

    public Instant getinit(){
        return this.init;
    }

    public Duration getfst(){
        return this.fst;
    }

    public Duration getsnd(){
        return this.snd;
    }

    public void inicia(){
        init=Instant.now();
        fst=Duration.ZERO;
        snd=Duration.ZERO;
    }

    public void parar(){
        if(fst.isZero()) fst = Duration.between(init, Instant.now());

        else if(snd.isZero()) snd = Duration.between(init, Instant.now());
    }

    public String primeiraParagem(){
        return fst.toString();
    }

    public String segundaParagem(){
        return snd.toString();
    }

    public String tempoSplit(){
        Duration diff = snd.minus(fst);

        return diff.toString();
    }

    public String tempoAbsoluto(){
        StringBuilder r = new StringBuilder();
        r.append("Arranque: ");
        r.append(init.toString());
        r.append("\n");
        r.append("1ª paragem: ");
        r.append(fst.addTo(init).toString());
        r.append("\n");
        r.append("2ª paragem: ");
        r.append(snd.addTo(init).toString());
        r.append("\n");

        return r.toString();
    }
}
