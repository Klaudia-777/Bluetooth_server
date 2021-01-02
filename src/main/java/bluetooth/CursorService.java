package bluetooth;

import java.awt.*;

public class CursorService {
    public void moveMouse(Point p) {
        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();

        for (GraphicsDevice device : gs) {
            GraphicsConfiguration[] configurations =
                    device.getConfigurations();
            for (GraphicsConfiguration config : configurations) {
                Rectangle bounds = config.getBounds();
                    Point b = MouseInfo.getPointerInfo().getLocation();
                    Point s = new Point(p.x + b.x, p.y + b.y);

                    try {
                        Robot r = new Robot(device);
                        if (bounds.contains(s)) {
                            System.out.println("mouse moved to " + s.toString());
                            r.mouseMove(s.x, s.y);
                        }
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }

                    return;
            }
        }
    }
}
