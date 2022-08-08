
package Connect_4;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Connect_4 extends javax.swing.JFrame {
        
    int a[][] = new int [8][8];
    {
        for (int i=0 ; i<8 ; i++)
            for (int j=0 ; j<8 ; j++)
                    a[i][j] = 0; 
    }
       JLabel labale (int x, int y){
       JLabel b[][] = {{but1,but2,but3,but4,but5,but6,but7,but8},{but9,but10,but11,but12,but13,but14,but15,but16},{but17,but18,but19,but20,but21,but22,but23,but24},{but25,but26,but27,but28,but29,but30,but31,but32},{but33,but34,but35,but36,but37,but38,but39,but40},{but41,but42,but43,but44,but45,but46,but47,but48},{but49,but50,but51,but52,but53,but54,but55,but56},{but57,but58,but59,but60,but61,but62,but63,but64}};
        return b[x][y];
    }
       int ap=1;
    void sp (){
        if (ap==1){
            ap=2;
            WhiteOrRed.setText("Red");
            WhiteOrRed.setForeground(Color.RED);
        }
        else if (ap==2){
            ap=1;
            WhiteOrRed.setText("White");
            WhiteOrRed.setForeground(Color.WHITE);
        }
    }
    void color (int x){
        if (ap==1){
           for (int i=7 ; i>=0 ; i--)
            {
                if (a[i][x]==0)
                {
                    a[i][x]=1;
                    labale(i , x).setText("o");
                    labale(i , x).setForeground(Color.WHITE);
                    sp();
                    break;
                }
            }
        }
        else if (ap==2){
            {
           for (int i=7 ; i>=0 ; i--)
            {
                if (a[i][x]==0)
                {
                    a[i][x]=2;
                    labale(i , x).setText("o");
                    labale(i , x).setForeground(Color.RED);
                    sp();
                    break;
                }
            }
        }
            
        }
    }
    static int h1=0;
    static int h2=0;
    int A (){
            int c=0;
            int d=0;
            for (int i=0 ; i<8 ; i++)
            {
                for (int j=0 ; j<8 ; j++)
                {
                    if (a[i][j]==1&&j<=4)
                    {
                        for (int k=0 ; k<4 ; k++)
                            if (a[i][j+k] == 1)
                                c++;
                    }
                    if (c==4)
                    {
                        return 1;
                    }
                    else 
                        c=0;
                    if (a[i][j]==2&&j<=4)
                    {
                        for (int k=0 ; k<4 ; k++)
                        {
                            if (a[i][j+k] == 2)
                                d++;
                        }
                        if (d==4)
                        {
                            return 2;
                        }
                        else 
                            d=0;
                    }
                }
            }
            return 0;
       }
    int B(){   
            int c=0;
            int d=0;
            for (int j=0 ; j<8 ; j++)
            {
                for (int i=0 ; i<8 ; i++)
                {
                    if (a[i][j]==1&&i<=4)
                    {
                        for (int k=0 ; k<4 ; k++)
                            if (a[i+k][j] == 1)
                                c++;
                    }
                    if (c==4)
                    {
                        return 1;
                    }
                    else 
                        c=0;
                    if (a[i][j]==2&&i<=4)
                    {
                        for (int k=0 ; k<4 ; k++)
                        {
                            if (a[i+k][j] == 2)
                                d++;
                        }
                        if (d==4)
                        {
                            return 2;
                        }
                        else 
                            d=0;
                    }
                }
            }
            return 0;
       }
    int C(){
        int c=0;
        int d=0;
        for (int i=0 ;i<8 ;i++)
            for(int j=0 ;j<8 ;j++)
            {
                if (a[i][j] == 1 && i<=4 &&j<=4)
                {
                    for (int k=0 ; k<4 ;k++)
                        if (a[i+k][j+k]==1)
                        {
                            c++;
                        }
                    }
                if (c==4)
                {
                    return 1;
                }
                else 
                    c=0;
                if (a[i][j]==2 && i<=4 && j<=4)
                {
                    for (int k=0 ; k<4 ;k++)
                    {
                        if (a[i+k][j+k]==2)
                        {
                            d++;
                        }
                    }
                    if (d==4)
                    {
                        return 2;
                    }
                    else 
                        d=0;
                }
            }
        return 0;
    }
    int D(){
        int c=0;
        int d=0;
        for (int i=0 ;i<8 ;i++)
            for(int j=0 ;j<8 ;j++)
            {
                if (i+j>=3&&i+j<12&&a[i][j]==1&&i<=4&&j>=3)
                {
                    for (int k=0 ; k<4 ;k++)
                        if (a[i+k][j-k]==1)
                        {
                            c++;
                        }
                    }
                if (c==4)
                {
                    return 1;
                }
                else 
                    c=0;
                if (i+j>=3&&i+j<12&&a[i][j]==2&&i<=4&&j>=3)
                {
                    for (int k=0 ; k<4 ;k++)
                        if (a[i+k][j-k]==2)
                        {
                            d++;
                        }
                    }
                if (d==4)
                {
                    return 2;
                }
                else 
                    d=0;
               
            }
        return 0;
    }
    void add (){
        if (A()==1||B()==1||C()==1||D()==1)
        {
            JOptionPane.showMessageDialog(null, "Palayer  \" White \"  is  Winner " , "Well Done!", JOptionPane.INFORMATION_MESSAGE);
            h1++;
            NumberOfWhite.setText(String.valueOf(h1));
            for (int i=0 ;i<8 ;i++)
                for (int j=0 ;j<8 ;j++)
                {
                    labale(i, j).setText("");
                    a[i][j]=0;
                }
            WhiteOrRed.setText("White");
            WhiteOrRed.setForeground(Color.WHITE);
            ap=1;
        }
        if (A()==2||B()==2||C()==2||D()==2)
        {
            JOptionPane.showMessageDialog(null, "Player  \" Red \"  is  Winner  " , "Well Done!", JOptionPane.NO_OPTION);
            h2++;
            NumberOfRed.setText(String.valueOf(h2));
            for (int i=0 ;i<8 ;i++)
                for (int j=0 ;j<8 ;j++)
                {
                    labale(i, j).setText("");
                    a[i][j]=0;
                }
            WhiteOrRed.setText("White");
            WhiteOrRed.setForeground(Color.WHITE);
            ap=1;
            
        }
    }

    public Connect_4() {
        setTitle("Connect 4");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        but1 = new javax.swing.JLabel();
        but9 = new javax.swing.JLabel();
        but17 = new javax.swing.JLabel();
        but25 = new javax.swing.JLabel();
        but33 = new javax.swing.JLabel();
        but41 = new javax.swing.JLabel();
        but49 = new javax.swing.JLabel();
        but57 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        but2 = new javax.swing.JLabel();
        but10 = new javax.swing.JLabel();
        but18 = new javax.swing.JLabel();
        but26 = new javax.swing.JLabel();
        but34 = new javax.swing.JLabel();
        but42 = new javax.swing.JLabel();
        but50 = new javax.swing.JLabel();
        but58 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        but3 = new javax.swing.JLabel();
        but11 = new javax.swing.JLabel();
        but19 = new javax.swing.JLabel();
        but27 = new javax.swing.JLabel();
        but35 = new javax.swing.JLabel();
        but43 = new javax.swing.JLabel();
        but51 = new javax.swing.JLabel();
        but59 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        but4 = new javax.swing.JLabel();
        but12 = new javax.swing.JLabel();
        but20 = new javax.swing.JLabel();
        but28 = new javax.swing.JLabel();
        but36 = new javax.swing.JLabel();
        but44 = new javax.swing.JLabel();
        but52 = new javax.swing.JLabel();
        but60 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        but5 = new javax.swing.JLabel();
        but13 = new javax.swing.JLabel();
        but21 = new javax.swing.JLabel();
        but29 = new javax.swing.JLabel();
        but37 = new javax.swing.JLabel();
        but45 = new javax.swing.JLabel();
        but53 = new javax.swing.JLabel();
        but61 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        but6 = new javax.swing.JLabel();
        but14 = new javax.swing.JLabel();
        but22 = new javax.swing.JLabel();
        but30 = new javax.swing.JLabel();
        but38 = new javax.swing.JLabel();
        but46 = new javax.swing.JLabel();
        but54 = new javax.swing.JLabel();
        but62 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        but7 = new javax.swing.JLabel();
        but15 = new javax.swing.JLabel();
        but23 = new javax.swing.JLabel();
        but31 = new javax.swing.JLabel();
        but39 = new javax.swing.JLabel();
        but47 = new javax.swing.JLabel();
        but55 = new javax.swing.JLabel();
        but63 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        but8 = new javax.swing.JLabel();
        but16 = new javax.swing.JLabel();
        but24 = new javax.swing.JLabel();
        but32 = new javax.swing.JLabel();
        but40 = new javax.swing.JLabel();
        but48 = new javax.swing.JLabel();
        but56 = new javax.swing.JLabel();
        but64 = new javax.swing.JLabel();
        BUT1 = new javax.swing.JButton();
        BUT2 = new javax.swing.JButton();
        BUT3 = new javax.swing.JButton();
        BUT4 = new javax.swing.JButton();
        BUT5 = new javax.swing.JButton();
        BUT6 = new javax.swing.JButton();
        BUT7 = new javax.swing.JButton();
        BUT8 = new javax.swing.JButton();
        Turn = new javax.swing.JLabel();
        WhiteOrRed = new javax.swing.JLabel();
        NumberOfRed = new javax.swing.JLabel();
        Red = new javax.swing.JLabel();
        NumberOfWhite = new javax.swing.JLabel();
        White = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Connect 4", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        but1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but1.setForeground(new java.awt.Color(255, 255, 255));
        but1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but9.setForeground(new java.awt.Color(255, 255, 255));
        but9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but17.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but17.setForeground(new java.awt.Color(255, 255, 255));
        but17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but25.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but25.setForeground(new java.awt.Color(255, 255, 255));
        but25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but33.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but33.setForeground(new java.awt.Color(255, 255, 255));
        but33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but41.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but41.setForeground(java.awt.Color.red);
        but41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but49.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but49.setForeground(new java.awt.Color(255, 255, 255));
        but49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but57.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but57.setForeground(new java.awt.Color(255, 255, 255));
        but57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(but1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but33, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but41, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 102));
        jPanel3.setPreferredSize(new java.awt.Dimension(60, 60));

        but2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but2.setForeground(new java.awt.Color(255, 255, 255));
        but2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but10.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but10.setForeground(new java.awt.Color(255, 255, 255));
        but10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but18.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but18.setForeground(new java.awt.Color(255, 255, 255));
        but18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but26.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but26.setForeground(new java.awt.Color(255, 255, 255));
        but26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but34.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but34.setForeground(new java.awt.Color(255, 255, 255));
        but34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but42.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but42.setForeground(new java.awt.Color(255, 255, 255));
        but42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but50.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but50.setForeground(new java.awt.Color(255, 255, 255));
        but50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but58.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but58.setForeground(java.awt.Color.red);
        but58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(but2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        but3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but3.setForeground(new java.awt.Color(255, 255, 255));
        but3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but11.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but11.setForeground(new java.awt.Color(255, 255, 255));
        but11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but19.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but19.setForeground(new java.awt.Color(255, 255, 255));
        but19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but27.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but27.setForeground(new java.awt.Color(255, 255, 255));
        but27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but35.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but35.setForeground(new java.awt.Color(255, 255, 255));
        but35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but43.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but43.setForeground(new java.awt.Color(255, 255, 255));
        but43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but51.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but51.setForeground(new java.awt.Color(255, 255, 255));
        but51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but59.setBackground(java.awt.Color.yellow);
        but59.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but59.setForeground(java.awt.Color.red);
        but59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(but3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but35, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 102));

        but4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but4.setForeground(new java.awt.Color(255, 255, 255));
        but4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but12.setForeground(new java.awt.Color(255, 255, 255));
        but12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but20.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but20.setForeground(new java.awt.Color(255, 255, 255));
        but20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but28.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but28.setForeground(new java.awt.Color(255, 255, 255));
        but28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but36.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but36.setForeground(new java.awt.Color(255, 255, 255));
        but36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but44.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but44.setForeground(new java.awt.Color(255, 255, 255));
        but44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but52.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but52.setForeground(new java.awt.Color(255, 255, 255));
        but52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but60.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but60.setForeground(new java.awt.Color(255, 255, 255));
        but60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(but4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but36, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        but5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but5.setForeground(new java.awt.Color(255, 255, 255));
        but5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but13.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but13.setForeground(new java.awt.Color(255, 255, 255));
        but13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but21.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but21.setForeground(new java.awt.Color(255, 255, 255));
        but21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but29.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but29.setForeground(new java.awt.Color(255, 255, 255));
        but29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but37.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but37.setForeground(new java.awt.Color(255, 255, 255));
        but37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but45.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but45.setForeground(new java.awt.Color(255, 255, 255));
        but45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but53.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but53.setForeground(new java.awt.Color(255, 255, 255));
        but53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but61.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but61.setForeground(new java.awt.Color(255, 255, 255));
        but61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but61, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(but5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 102));

        but6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but6.setForeground(new java.awt.Color(255, 255, 255));
        but6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but14.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but14.setForeground(new java.awt.Color(255, 255, 255));
        but14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but22.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but22.setForeground(new java.awt.Color(255, 255, 255));
        but22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but30.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but30.setForeground(new java.awt.Color(255, 255, 255));
        but30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but38.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but38.setForeground(new java.awt.Color(255, 255, 255));
        but38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but46.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but46.setForeground(new java.awt.Color(255, 255, 255));
        but46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but54.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but54.setForeground(new java.awt.Color(255, 255, 255));
        but54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but62.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but62.setForeground(new java.awt.Color(255, 255, 255));
        but62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(but6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but30, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but38, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));

        but7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but7.setForeground(new java.awt.Color(255, 255, 255));
        but7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but15.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but15.setForeground(new java.awt.Color(255, 255, 255));
        but15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but23.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but23.setForeground(new java.awt.Color(255, 255, 255));
        but23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but31.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but31.setForeground(new java.awt.Color(255, 255, 255));
        but31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but39.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but39.setForeground(new java.awt.Color(255, 255, 255));
        but39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but47.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but47.setForeground(new java.awt.Color(255, 255, 255));
        but47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but55.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but55.setForeground(new java.awt.Color(255, 255, 255));
        but55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but63.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but63.setForeground(new java.awt.Color(255, 255, 255));
        but63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(but7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but23, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but39, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 102));

        but8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but8.setForeground(new java.awt.Color(255, 255, 255));
        but8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but16.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but16.setForeground(new java.awt.Color(255, 255, 255));
        but16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but24.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but24.setForeground(new java.awt.Color(255, 255, 255));
        but24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but32.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but32.setForeground(new java.awt.Color(255, 255, 255));
        but32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but40.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but40.setForeground(new java.awt.Color(255, 255, 255));
        but40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but48.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but48.setForeground(new java.awt.Color(255, 255, 255));
        but48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but56.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but56.setForeground(new java.awt.Color(255, 255, 255));
        but56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        but64.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        but64.setForeground(new java.awt.Color(255, 255, 255));
        but64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(but8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(but64, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(but8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but32, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(but64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BUT1.setBackground(java.awt.Color.yellow);
        BUT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT1ActionPerformed(evt);
            }
        });

        BUT2.setBackground(java.awt.Color.yellow);
        BUT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT2ActionPerformed(evt);
            }
        });

        BUT3.setBackground(java.awt.Color.yellow);
        BUT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT3ActionPerformed(evt);
            }
        });

        BUT4.setBackground(java.awt.Color.yellow);
        BUT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT4ActionPerformed(evt);
            }
        });

        BUT5.setBackground(java.awt.Color.yellow);
        BUT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT5ActionPerformed(evt);
            }
        });

        BUT6.setBackground(java.awt.Color.yellow);
        BUT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT6ActionPerformed(evt);
            }
        });

        BUT7.setBackground(java.awt.Color.yellow);
        BUT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT7ActionPerformed(evt);
            }
        });

        BUT8.setBackground(java.awt.Color.yellow);
        BUT8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUT8ActionPerformed(evt);
            }
        });

        Turn.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Turn.setForeground(java.awt.Color.yellow);
        Turn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Turn.setText("Turn :");

        WhiteOrRed.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        WhiteOrRed.setForeground(new java.awt.Color(255, 255, 255));
        WhiteOrRed.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        WhiteOrRed.setText("White");

        NumberOfRed.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        NumberOfRed.setForeground(java.awt.Color.red);
        NumberOfRed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberOfRed.setText("0");

        Red.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Red.setForeground(java.awt.Color.red);
        Red.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Red.setText("Red :");

        NumberOfWhite.setBackground(new java.awt.Color(255, 255, 255));
        NumberOfWhite.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        NumberOfWhite.setForeground(new java.awt.Color(255, 255, 255));
        NumberOfWhite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NumberOfWhite.setText("0");

        White.setBackground(new java.awt.Color(255, 255, 255));
        White.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        White.setForeground(new java.awt.Color(255, 255, 255));
        White.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        White.setText("White :");

        jPanel10.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("De.Coder();");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("JR.Y");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUT1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUT2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUT3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BUT4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Turn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WhiteOrRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NumberOfRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Red, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NumberOfWhite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(White, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BUT8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Turn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(WhiteOrRed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(White, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumberOfWhite, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Red, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumberOfRed, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BUT8, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(BUT6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BUT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BUT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT1ActionPerformed
        color(0);
        add();
    }//GEN-LAST:event_BUT1ActionPerformed

    private void BUT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT2ActionPerformed
        color(1);
        add();
    }//GEN-LAST:event_BUT2ActionPerformed

    private void BUT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT3ActionPerformed
        color(2);
        add();
    }//GEN-LAST:event_BUT3ActionPerformed

    private void BUT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT4ActionPerformed
        color(3);
        add();
    }//GEN-LAST:event_BUT4ActionPerformed

    private void BUT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT5ActionPerformed
        color(4);
        add();
    }//GEN-LAST:event_BUT5ActionPerformed

    private void BUT6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT6ActionPerformed
        color(5);
        add();
    }//GEN-LAST:event_BUT6ActionPerformed

    private void BUT7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT7ActionPerformed
        color(6);
        add();
    }//GEN-LAST:event_BUT7ActionPerformed

    private void BUT8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUT8ActionPerformed
        color(7);
        add();
    }//GEN-LAST:event_BUT8ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Connect_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Connect_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Connect_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Connect_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Connect_4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BUT1;
    private javax.swing.JButton BUT2;
    private javax.swing.JButton BUT3;
    private javax.swing.JButton BUT4;
    private javax.swing.JButton BUT5;
    private javax.swing.JButton BUT6;
    private javax.swing.JButton BUT7;
    private javax.swing.JButton BUT8;
    private javax.swing.JLabel NumberOfRed;
    private javax.swing.JLabel NumberOfWhite;
    private javax.swing.JLabel Red;
    private javax.swing.JLabel Turn;
    private javax.swing.JLabel White;
    private javax.swing.JLabel WhiteOrRed;
    private javax.swing.JLabel but1;
    private javax.swing.JLabel but10;
    private javax.swing.JLabel but11;
    private javax.swing.JLabel but12;
    private javax.swing.JLabel but13;
    private javax.swing.JLabel but14;
    private javax.swing.JLabel but15;
    private javax.swing.JLabel but16;
    private javax.swing.JLabel but17;
    private javax.swing.JLabel but18;
    private javax.swing.JLabel but19;
    private javax.swing.JLabel but2;
    private javax.swing.JLabel but20;
    private javax.swing.JLabel but21;
    private javax.swing.JLabel but22;
    private javax.swing.JLabel but23;
    private javax.swing.JLabel but24;
    private javax.swing.JLabel but25;
    private javax.swing.JLabel but26;
    private javax.swing.JLabel but27;
    private javax.swing.JLabel but28;
    private javax.swing.JLabel but29;
    private javax.swing.JLabel but3;
    private javax.swing.JLabel but30;
    private javax.swing.JLabel but31;
    private javax.swing.JLabel but32;
    private javax.swing.JLabel but33;
    private javax.swing.JLabel but34;
    private javax.swing.JLabel but35;
    private javax.swing.JLabel but36;
    private javax.swing.JLabel but37;
    private javax.swing.JLabel but38;
    private javax.swing.JLabel but39;
    private javax.swing.JLabel but4;
    private javax.swing.JLabel but40;
    private javax.swing.JLabel but41;
    private javax.swing.JLabel but42;
    private javax.swing.JLabel but43;
    private javax.swing.JLabel but44;
    private javax.swing.JLabel but45;
    private javax.swing.JLabel but46;
    private javax.swing.JLabel but47;
    private javax.swing.JLabel but48;
    private javax.swing.JLabel but49;
    private javax.swing.JLabel but5;
    private javax.swing.JLabel but50;
    private javax.swing.JLabel but51;
    private javax.swing.JLabel but52;
    private javax.swing.JLabel but53;
    private javax.swing.JLabel but54;
    private javax.swing.JLabel but55;
    private javax.swing.JLabel but56;
    private javax.swing.JLabel but57;
    private javax.swing.JLabel but58;
    private javax.swing.JLabel but59;
    private javax.swing.JLabel but6;
    private javax.swing.JLabel but60;
    private javax.swing.JLabel but61;
    private javax.swing.JLabel but62;
    private javax.swing.JLabel but63;
    private javax.swing.JLabel but64;
    private javax.swing.JLabel but7;
    private javax.swing.JLabel but8;
    private javax.swing.JLabel but9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
