package multithreading.ballbounceV2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author simple_huang@foxmail.com on 2017/10/19.
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BounceFrame extends JFrame {
    private BallComponent component;
    public static final int STEPS = 2000;
    public static final int DELAY = 3;

    public BounceFrame() {
        setTitle("Bounce");
        component = new BallComponent();
        add(component, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "START", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("thread start " + Thread.currentThread().getName());
                        addBall();
                    }
                });
                t.start();
            }
        });//lambda 表示: e -> addBall()
        addButton(buttonPanel, "CLOSE", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener) {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall() {
        try {
            Ball ball = new Ball();
            component.add(ball);
            for (int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
//                component.paint(component.getGraphics());
                component.repaint();
                //interrupt()方法只会请求中断线程, 将中断状态置为true, 但线程不会中断
                //但如果interrupt()后接一个sleep方法, 那么sleep()方法会抛出InterruptException异常
                //Thread的静态方法interrupted()可以检测中断状态, 并清除这个状态
//                Thread.currentThread().interrupt();
                Thread.sleep(DELAY);
//                System.out.println(Thread.currentThread().isInterrupted());
//                System.out.println(Thread.interrupted());
//                System.out.println(Thread.currentThread().isInterrupted());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

