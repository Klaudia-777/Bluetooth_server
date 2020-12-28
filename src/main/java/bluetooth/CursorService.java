package bluetooth;

import java.awt.*;

public class CursorService {
    public void moveMouse(Point p) {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();

        // Search the devices for the one that draws the specified point.
        for (GraphicsDevice device : gs) {
            GraphicsConfiguration[] configurations =
                    device.getConfigurations();
            for (GraphicsConfiguration config : configurations) {
                Rectangle bounds = config.getBounds();
                System.out.println(bounds);
                if (bounds.contains(p)) {
                    System.out.println("contains p");
                    // Set point to screen coordinates.
                    Point b = bounds.getLocation();
                    System.out.println("current" + b);
                    Point s = new Point(p.x - b.x, p.y - b.y);
                    System.out.println("new" + s);

                    try {
                        Robot r = new Robot(device);
                        r.mouseMove(s.x, s.y);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }

                    return;
                }
            }
        }
        // Couldn't move to the point, it may be off screen.
    }
}
