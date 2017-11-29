import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by mlobo1997 on 27/06/2017.
 */
public class MusicaComVideo extends Faixa implements Playable{
    private String video;

    public MusicaComVideo(String nome, String autor, double duracao, int classificacao, ArrayList<String> letra, int numeroVezesTocada, LocalDateTime ultimavez, String video) {
        super(nome, autor, duracao, classificacao, letra, numeroVezesTocada, ultimavez);
        this.video = video;
    }

    public void play(){
        //System.audio.play(letra);
        System.out.println(video);
    }
}
