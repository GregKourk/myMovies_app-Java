package GUIFrames;

import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import myMovies_new.*;


public class StatiticsFrame extends javax.swing.JFrame {

    MainFrame mainMenu;
    JFrame previousFrame ;
    ArrayList<String> favoriteList;
    EntityManager em;
    //λιστα με τις Movies βασει φθινουσας σειρας rating που θα μπουν στον πινακα με τις 10 καλυτερες Movies
    List<Movie> moviesToPutIntoTable = new ArrayList<>();  
    //αντικειμενο τυπου Movie που αποθηκευεται η καλυτερη Movie απο καθε FavoriteList
    Movie movieWithBestRatingOfEveryList = new Movie();   
    //αντικειμενο τυπου FavoriteList που αποθηκευεται η FavoriteList απο καθε ονομα λιστας
    FavoriteList listToFindBestMovie = new FavoriteList();    
    //Μεταβλητη για να ξερουμε αν πατηθηκε το κουμπι για τις 10 καλυτερες Movies
    boolean top10MoviesButton = false;          
    //Μεταβλητη για να ξερουμε αν πατηθηκε το κουμπι με τις καλυτερες Movies ανα FavoriteList
    boolean topMoviesByListButton = false;                      
    
    public void goBack() {
    GuiUtils.disposeAndOpenUpperFrame(this, mainMenu);
    }
    
    public StatiticsFrame(MainFrame mainMenu, JFrame previousFrame, ArrayList<String> favoriteList) {
        
        this.mainMenu = mainMenu;
        this.favoriteList = favoriteList;
        this.previousFrame = previousFrame;
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMovies_newPU");
        em = emf.createEntityManager();
        previousFrame.dispose();

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("myMovies_new - Statitics");
        this.setVisible(true);
        
        Top10MoviesButtonJPanel.setVisible(true);
        Top10MoviesTableJPanel.setVisible(false);
        TopMoviesByListTableJPanel.setVisible(false);
        
        this.addWindowListener(exitListener); // exitListener που ζητάει επιβεβαίωση για έξοδο 
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex.getMessage(), "Πρόβλημα με τη βάση...", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            GuiUtils.exitProgram();
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myMovies_newPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMovies_newPU").createEntityManager();
        movieQuery = java.beans.Beans.isDesignTime() ? null : myMovies_newPUEntityManager.createQuery("SELECT m FROM Movie m");
        movieList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : movieQuery.getResultList();
        Top10MoviesButtonJPanel = new javax.swing.JPanel();
        Top10MoviesButton = new javax.swing.JButton();
        TopMoviesByListButton = new javax.swing.JButton();
        Top10MoviesTableJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Top10MoviesTable = new javax.swing.JTable();
        TopMoviesByListTableJPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TopMoviesByListTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        InitialScreenMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        FavouriteListManagementMenuItem = new javax.swing.JMenuItem();
        MovieSearchMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Top10MoviesButton.setText("Top 10 movies");
        Top10MoviesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Top10MoviesButtonActionPerformed(evt);
            }
        });

        TopMoviesByListButton.setText("Top movies by list");
        TopMoviesByListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopMoviesByListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Top10MoviesButtonJPanelLayout = new javax.swing.GroupLayout(Top10MoviesButtonJPanel);
        Top10MoviesButtonJPanel.setLayout(Top10MoviesButtonJPanelLayout);
        Top10MoviesButtonJPanelLayout.setHorizontalGroup(
            Top10MoviesButtonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top10MoviesButtonJPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Top10MoviesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 544, Short.MAX_VALUE)
                .addComponent(TopMoviesByListButton)
                .addGap(48, 48, 48))
        );
        Top10MoviesButtonJPanelLayout.setVerticalGroup(
            Top10MoviesButtonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top10MoviesButtonJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Top10MoviesButtonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Top10MoviesButton)
                    .addComponent(TopMoviesByListButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Top10MoviesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Movie Name", "Movie Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Top10MoviesTable);

        javax.swing.GroupLayout Top10MoviesTableJPanelLayout = new javax.swing.GroupLayout(Top10MoviesTableJPanel);
        Top10MoviesTableJPanel.setLayout(Top10MoviesTableJPanelLayout);
        Top10MoviesTableJPanelLayout.setHorizontalGroup(
            Top10MoviesTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top10MoviesTableJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 69, Short.MAX_VALUE))
        );
        Top10MoviesTableJPanelLayout.setVerticalGroup(
            Top10MoviesTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Top10MoviesTableJPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TopMoviesByListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Movie Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TopMoviesByListTable);

        javax.swing.GroupLayout TopMoviesByListTableJPanelLayout = new javax.swing.GroupLayout(TopMoviesByListTableJPanel);
        TopMoviesByListTableJPanel.setLayout(TopMoviesByListTableJPanelLayout);
        TopMoviesByListTableJPanelLayout.setHorizontalGroup(
            TopMoviesByListTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopMoviesByListTableJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        TopMoviesByListTableJPanelLayout.setVerticalGroup(
            TopMoviesByListTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopMoviesByListTableJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jMenu1.setText("myMovies");

        InitialScreenMenuItem.setText("1. Initial Screen");
        InitialScreenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitialScreenMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(InitialScreenMenuItem);
        jMenu1.add(jSeparator1);

        FavouriteListManagementMenuItem.setText("2. Favourite List Management");
        FavouriteListManagementMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavouriteListManagementMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(FavouriteListManagementMenuItem);

        MovieSearchMenuItem.setText("3. Movie Search");
        MovieSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovieSearchMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(MovieSearchMenuItem);
        jMenu1.add(jSeparator2);

        ExitMenuItem.setText("4. Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Top10MoviesTableJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TopMoviesByListTableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Top10MoviesButtonJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Top10MoviesButtonJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Top10MoviesTableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TopMoviesByListTableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ActionPerformed για τα κουμπιά
    private void InitialScreenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialScreenMenuItemActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_InitialScreenMenuItemActionPerformed

    private void FavouriteListManagementMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavouriteListManagementMenuItemActionPerformed
        // TODO add your handling code here:
        new FavouriteListFrame(mainMenu, this, favoriteList);
    }//GEN-LAST:event_FavouriteListManagementMenuItemActionPerformed

    private void MovieSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovieSearchMenuItemActionPerformed
        // TODO add your handling code here:
        new MovieSearchFrame(mainMenu, this, favoriteList);
    }//GEN-LAST:event_MovieSearchMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        // TODO add your handling code here:
        GuiUtils.exitProgram();
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void Top10MoviesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Top10MoviesButtonActionPerformed
        // TODO add your handling code here:
        Top10MoviesButtonJPanel.setVisible(true);
        Top10MoviesTableJPanel.setVisible(true);
        top10MoviesButton = true;
        if (topMoviesByListButton==true){
            TopMoviesByListTableJPanel.setVisible(true);
        }
        else{
            TopMoviesByListTableJPanel.setVisible(false);
        }
        
        try {
            //ευρεση καλυτερων Movies
            moviesToPutIntoTable = DBUtils.getMoviesEntitiesByRatingDescList();
            //περασμα στον πινακα μονο τις 10 καλυτερες Movies
            for (int rowCounter=0; rowCounter<moviesToPutIntoTable.size(); rowCounter++){
                Top10MoviesTable.setValueAt(moviesToPutIntoTable.get(rowCounter).getMovieName(), rowCounter, 0);
                Top10MoviesTable.setValueAt(moviesToPutIntoTable.get(rowCounter).getMovieRating(), rowCounter, 1);
            }
        } catch (Exception ex) {
            Logger.getLogger(StatiticsFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Top10MoviesButtonActionPerformed

    private void TopMoviesByListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopMoviesByListButtonActionPerformed
        // TODO add your handling code here:
        Top10MoviesButtonJPanel.setVisible(true);
        TopMoviesByListTableJPanel.setVisible(true);
        topMoviesByListButton = true;
        if (top10MoviesButton==true){
            Top10MoviesTableJPanel.setVisible(true);
        }
        else{
            Top10MoviesTableJPanel.setVisible(false);
        }
        
        //αν υπαρχουν FavoriteLists προς εμφανιση καλυτερης Movie
        if(!favoriteList.isEmpty()){
            //τοσες σειρες οσες ειναι και οι FavoriteLists
            ((DefaultTableModel) TopMoviesByListTable.getModel()).setRowCount(favoriteList.size());
            
            for (int rowCounter=0; rowCounter<favoriteList.size(); rowCounter++){
                //βρισκω την FavoriteList που αντιστοιχει σε αυτο το ονομα 
                try {
                    listToFindBestMovie = DBUtils.getFavoriteListEtityFromFavoriteListName(favoriteList.get(rowCounter));
                } catch (Exception ex) {
                    Logger.getLogger(StatiticsFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                //βρισκω την καλυτερη Movie για την συγκεκριμενη FavoriteList
                movieWithBestRatingOfEveryList = listToFindBestMovie.getMaxRatingMovie();
                //προσθεση του ονοματος της καλυτερης Movie στον πινακα
                TopMoviesByListTable.setValueAt(movieWithBestRatingOfEveryList.getMovieName(), rowCounter, 0);
            }
        }
    }//GEN-LAST:event_TopMoviesByListButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JMenuItem FavouriteListManagementMenuItem;
    private javax.swing.JMenuItem InitialScreenMenuItem;
    private javax.swing.JMenuItem MovieSearchMenuItem;
    private javax.swing.JButton Top10MoviesButton;
    private javax.swing.JPanel Top10MoviesButtonJPanel;
    private javax.swing.JTable Top10MoviesTable;
    private javax.swing.JPanel Top10MoviesTableJPanel;
    private javax.swing.JButton TopMoviesByListButton;
    private javax.swing.JTable TopMoviesByListTable;
    private javax.swing.JPanel TopMoviesByListTableJPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private java.util.List<model.Movie> movieList;
    private javax.persistence.Query movieQuery;
    private javax.persistence.EntityManager myMovies_newPUEntityManager;
    // End of variables declaration//GEN-END:variables
}
