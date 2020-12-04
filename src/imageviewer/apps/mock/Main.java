package imageviewer.apps.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Image;
import view.ImageDisplay;
import view.ImageLoader;

public class Main {

    public static void main(String[] args) {
        List<Image> images = new MockImageLoader().load();
        ImageDisplay imageDisplay = new MockImageDisplay();
        imageDisplay.display(images.get(0));
        Scanner scanner = new Scanner(System.in);
        int index = 0;
        while(true) {
            imageDisplay.display(images.get(index));
            String input = scanner.next().toUpperCase();
            if (input.equals("N")) index++;
            if (input.equals("P")) index--;
            if (input.equals("Q")) System.exit(0);
        }
    }
    
    public class MockImageDisplay implements ImageDisplay {

        @Override
        public void display(Image image) {
            System.out.println(image.getName());
        }
        
    }
    
    public static class MockImageLoader implements ImageLoader {

        @Override
        public List<Image> load() {
            List<Image> list = new ArrayList<>();
            list.add(new Image("hola"));
            return null;
        }
        
    }
}
