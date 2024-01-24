import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Video extends Application {

    private List<String> videoList = new ArrayList<>();
    private int lastRandomIndex = -1;

    @Override
    public void start(Stage primaryStage) {
        // Popolamento della lista dei video
        videoList.add("C:\\path\\to\\video1.mp4");
        videoList.add("C:\\path\\to\\video2.mp4");
        videoList.add("C:\\path\\to\\video3.mp4");
        videoList.add("C:\\path\\to\\video4.mp4");
        videoList.add("C:\\path\\to\\video5.mp4");
        videoList.add("C:\\path\\to\\video6.mp4");
        videoList.add("C:\\path\\to\\video7.mp4");
        videoList.add("C:\\path\\to\\video8.mp4");

        // Creazione del pulsante per riprodurre un video
        Button playButton = new Button("Riproduci Video");
        playButton.setOnAction(e -> videoRandom());

        // Stampa su console il numero del video selezionato casualmente
        for (int i = 0; i < 10; i++) {
            int randomIndex = getRandomIndex();
            System.out.println("Riproduzione di: Video " + (randomIndex + 1));
            try {
                Thread.sleep(1000); // Ritardo di 1 secondo (1000 millisecondi)
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private int getRandomIndex() {
        int randomIndex;
        do {
            randomIndex = (int) (Math.random() * videoList.size());
        } while (randomIndex == lastRandomIndex);
        lastRandomIndex = randomIndex;
        return randomIndex;
    }

    private void videoRandom() {
        int randomIndex = getRandomIndex();
        System.out.println("Riproduzione di: " + videoList.get(randomIndex));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
