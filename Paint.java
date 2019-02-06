import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JPanel implements MouseListener, MouseMotionListener {
  
    private static final long serialVersionUID = 1L;
    int xPressed,yPressed;
    int xReleased,yReleased;
    int xDragged,yDragged;
    private JFrame frame;
    
    public Paint(JFrame f)
    {
        frame = f;
    	setPreferredSize(new Dimension(1366, 768));
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		initComponents();
    }

	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leaveButton = new javax.swing.JButton();
        DrawingJPanel = new javax.swing.JPanel();

        leaveButton.setText("Leave");
        leaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaveButtonActionPerformed(evt);
            }
        });

        DrawingJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout DrawingJPanelLayout = new javax.swing.GroupLayout(DrawingJPanel);
        DrawingJPanel.setLayout(DrawingJPanelLayout);
        DrawingJPanelLayout.setHorizontalGroup(
            DrawingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DrawingJPanelLayout.setVerticalGroup(
            DrawingJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1180, Short.MAX_VALUE)
                .addComponent(leaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addComponent(DrawingJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(leaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DrawingJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void leaveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_leaveButtonActionPerformed
	{//GEN-HEADEREND:event_leaveButtonActionPerformed
		// TODO add your handling code here:
    	frame.dispose();
	}//GEN-LAST:event_leaveButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DrawingJPanel;
    private javax.swing.JButton leaveButton;
    // End of variables declaration//GEN-END:variables
    
    
    @Override
    public void mouseDragged(MouseEvent e) {
    	Graphics g = getGraphics();
    if (yDragged <=760 && e.getY() <=760)	
    	g.drawLine(xDragged, yDragged, e.getX(), e.getY());
    xDragged = e.getX();
    yDragged = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    	xDragged = e.getX();
        yDragged = e.getY();
        //System.out.println("xPressed: "+xPressed+" ,yPressed: "+yPressed);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    	xDragged = 0;
        yDragged = 0;
        //System.out.println("xReleased: "+xReleased+" ,yReleased: "+yReleased);
    }
}