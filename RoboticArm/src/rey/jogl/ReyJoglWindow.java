/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rey.jogl;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author Urso
 */
public abstract class ReyJoglWindow
                    extends
                        ReyJogl
                    implements
                            GLEventListener
                           ,KeyListener
                           ,MouseListener
{
    private String  title;
    private int     width;
    private int    height;

    // Events
    private Evento            event;
    // Keyboard Events
    private KeyEvent       keyInput;
    // Mouse Events
    private MouseEvent   mouseInput;

    public ReyJoglWindow(String t, int w, int h){
        this.title = t;
        this.width = w;
        this.height = h;
    }

    public abstract void render();
    public abstract void start();
    public abstract void keyInput();
    public abstract void mouseInput();

    /* Key Events */
    @Override
    public void keyTyped(KeyEvent e) {
        this.keyInput = e;
        this.event = Evento.KEY_TYPED;
        keyInput();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyInput = e;
        this.event = Evento.KEY_PRESSED;
        keyInput();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyInput = e;
        this.event = Evento.KEY_RELEASED;
        keyInput();
    }
    /* --- */

    /* Mouse Events */
    @Override
    public void mouseClicked(MouseEvent e) {
        this.mouseInput = e;
        this.event = Evento.MOUSE_CLICKED;
        mouseInput();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.mouseInput = e;
        this.event = Evento.MOUSE_ENTERED;
        mouseInput();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.mouseInput = e;
        this.event = Evento.MOUSE_EXITED;
        mouseInput();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseInput = e;
        this.event = Evento.MOUSE_PRESSED;
        mouseInput();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.mouseInput = e;
        this.event = Evento.MOUSE_RELEASED;
        mouseInput();
    }
    /* --- */

    @Override
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        this.setGl(drawable.getGL());
        this.setGlu(new GLU());
        this.setGlut(new GLUT());
        System.err.println("INIT GL IS: " + this.getGl().getClass().getName());

        // Enable VSync
        this.getGl().setSwapInterval(1);

        // Enable DEPTH Test
        this.getGl().glEnable(GL.GL_DEPTH_TEST);

        // Setup the drawing area and shading mode
        this.getGl().glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        this.getGl().glShadeModel(this.getGl().GL_SMOOTH_POINT_SIZE_GRANULARITY);

        start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        this.getGl().glClear(this.getGl().GL_COLOR_BUFFER_BIT | this.getGl().GL_DEPTH_BUFFER_BIT);
        this.getGl().glLoadIdentity();

        render();

        this.getGl().glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        this.getGl().glViewport(0, 0, width, height);
        this.getGl().glMatrixMode(this.getGl().GL_PROJECTION);
        this.getGl().glLoadIdentity();
        this.getGlu().gluPerspective(45.0f, h, 1.0, 20.0);
        this.getGl().glMatrixMode(this.getGl().GL_MODELVIEW);
        this.getGl().glLoadIdentity();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        
    }

    public static void exec(ReyJoglWindow obj)
    {
        Frame frame = new Frame(obj.getTitle());
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(obj);
        canvas.addKeyListener(obj);
        canvas.addMouseListener(obj);
        
        frame.add(canvas);
        frame.setSize(obj.getWidth(), obj.getHeight());
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

  
    /**
     * @return the keyCode
     */
    public KeyEvent getKeyInput() {
        return keyInput;
    }

    /**
     * @param keyCode the keyCode to set
     */
    public void setKeyInput(KeyEvent keyInput) {
        this.keyInput = keyInput;
    }

    /**
     * @return the mouseCode
     */
    public MouseEvent getMouseInput() {
        return mouseInput;
    }

    /**
     * @param mouseCode the mouseCode to set
     */
    public void setMouseInput(MouseEvent mouseInput) {
        this.mouseInput = mouseInput;
    }

    /**
     * @return the event
     */
    public Evento getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Evento event) {
        this.event = event;
    }
}
