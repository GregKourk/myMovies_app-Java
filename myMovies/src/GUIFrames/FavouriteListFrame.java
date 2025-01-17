package GUIFrames;

import java.awt.event.*;
import javax.persistence.*;
import javax.swing.*;
import model.*;
import myMovies_new.GuiUtils;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import myMovies_new.DBUtils;


public class FavouriteListFrame extends javax.swing.JFrame {

    MainFrame mainMenu;
    JFrame previousFrame;
    ArrayList<String> favoriteList;
    EntityManager em;
    FavoriteList list;
    //αν εχει επιλεγει καποια FavoriteList τοτε γινεται true για να ενεργοποιηθουν τα κουμπια proccess, delete
    boolean listFromjListChoosed = false;        
    
    public void goBack() {
    GuiUtils.disposeAndOpenUpperFrame(this, mainMenu);
    }
    
    public FavouriteListFrame(MainFrame mainMenu,JFrame previousFrame, ArrayList<String> favoriteList) {
        
        this.mainMenu = mainMenu;
        this.favoriteList = favoriteList;
        this.previousFrame = previousFrame;
        
        try{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myMovies_newPU");
        em = emf.createEntityManager();
        previousFrame.dispose();

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("myMovies_new - Favourite Lists");
        this.setVisible(true);
        
        ListManagementJPanel.setVisible(true);
        FavouriteListTableJPanel.setVisible(false);
        jPanel_Empty.setVisible(true);
        
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        myMovies_newPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("myMovies_newPU").createEntityManager();
        favoriteListQuery = java.beans.Beans.isDesignTime() ? null : myMovies_newPUEntityManager.createQuery("SELECT f FROM FavoriteList f");
        favoriteListList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : favoriteListQuery.getResultList();
        ListManagementJPanel = new javax.swing.JPanel();
        FavouriteListsLabel = new javax.swing.JLabel();
        FavouriteListsJList = new javax.swing.JScrollPane();
        FavouriteListJList = new javax.swing.JList<>();
        CreateListButton = new javax.swing.JButton();
        ProcessListButton = new javax.swing.JButton();
        DeleteListButton = new javax.swing.JButton();
        FavouriteListTableJPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        favouriteListComponentsJTable = new javax.swing.JTable();
        jPanel_Empty = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        InitialScreenMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MovieSearchMenuItem = new javax.swing.JMenuItem();
        StatiticsMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FavouriteListsLabel.setText("Favourites Lists");

        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, FavouriteListJList);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${favoriteListName}"));
        bindingGroup.addBinding(jListBinding);
        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, favoriteListList, org.jdesktop.beansbinding.ObjectProperty.create(), FavouriteListJList, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        FavouriteListJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FavouriteListJListMouseClicked(evt);
            }
        });
        FavouriteListsJList.setViewportView(FavouriteListJList);

        CreateListButton.setText("Create List");
        CreateListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateListButtonActionPerformed(evt);
            }
        });

        ProcessListButton.setText("Process List");
        ProcessListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessListButtonActionPerformed(evt);
            }
        });

        DeleteListButton.setText("Delete List");
        DeleteListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteListButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ListManagementJPanelLayout = new javax.swing.GroupLayout(ListManagementJPanel);
        ListManagementJPanel.setLayout(ListManagementJPanelLayout);
        ListManagementJPanelLayout.setHorizontalGroup(
            ListManagementJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListManagementJPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(FavouriteListsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(ListManagementJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CreateListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProcessListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(ListManagementJPanelLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(FavouriteListsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ListManagementJPanelLayout.setVerticalGroup(
            ListManagementJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListManagementJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FavouriteListsLabel)
                .addGap(18, 18, 18)
                .addGroup(ListManagementJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ListManagementJPanelLayout.createSequentialGroup()
                        .addComponent(CreateListButton)
                        .addGap(40, 40, 40)
                        .addComponent(ProcessListButton)
                        .addGap(44, 44, 44)
                        .addComponent(DeleteListButton))
                    .addComponent(FavouriteListsJList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        favouriteListComponentsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Movie Title", "Movie Rating", "Movie Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(favouriteListComponentsJTable);

        javax.swing.GroupLayout FavouriteListTableJPanelLayout = new javax.swing.GroupLayout(FavouriteListTableJPanel);
        FavouriteListTableJPanel.setLayout(FavouriteListTableJPanelLayout);
        FavouriteListTableJPanelLayout.setHorizontalGroup(
            FavouriteListTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FavouriteListTableJPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        FavouriteListTableJPanelLayout.setVerticalGroup(
            FavouriteListTableJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FavouriteListTableJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_EmptyLayout = new javax.swing.GroupLayout(jPanel_Empty);
        jPanel_Empty.setLayout(jPanel_EmptyLayout);
        jPanel_EmptyLayout.setHorizontalGroup(
            jPanel_EmptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );
        jPanel_EmptyLayout.setVerticalGroup(
            jPanel_EmptyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        MovieSearchMenuItem.setText("2, Movie Search");
        MovieSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovieSearchMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(MovieSearchMenuItem);

        StatiticsMenuItem.setText("3. Statitics");
        StatiticsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatiticsMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(StatiticsMenuItem);
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
                .addComponent(ListManagementJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FavouriteListTableJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel_Empty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_Empty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FavouriteListTableJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ListManagementJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ActionPerformed για τα κουμπιά
    private void InitialScreenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitialScreenMenuItemActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_InitialScreenMenuItemActionPerformed

    private void MovieSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovieSearchMenuItemActionPerformed
        // TODO add your handling code here:
        new MovieSearchFrame(mainMenu, this, favoriteList);
    }//GEN-LAST:event_MovieSearchMenuItemActionPerformed

    private void StatiticsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatiticsMenuItemActionPerformed
        // TODO add your handling code here:
        new StatiticsFrame(mainMenu, this, favoriteList);
    }//GEN-LAST:event_StatiticsMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        // TODO add your handling code here:
        GuiUtils.exitProgram();
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void CreateListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateListButtonActionPerformed
        // TODO add your handling code here:
        
        //Panel εισαγωγης λιστας
        String createNewList = JOptionPane.showInputDialog(null, "Create new favourite list?");         
        int listCounter=0;
        
        //Αν ο χρηστης εχει δωσει κενο ονομα
        if (createNewList == null || createNewList.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must enter a name to create a list", "Enter name for list", JOptionPane.INFORMATION_MESSAGE);
            createNewList = JOptionPane.showInputDialog(null, "Give name for new favourite list");
        }    
        
        //Αν ο χρηστης δεν εχει δωσει ενα ονομα,
        //ελεγχος αν υπαρχει ηδη η λιστα,
        //αλλιως δημιουργια αντικειμενου τυπου Favorite_List και εισαγωγη του στην βαση
        if (createNewList != null && !createNewList.isEmpty()){
            while (listCounter<favoriteList.size()){
                if (Objects.equals(createNewList, favoriteList.get(listCounter))){
                    JOptionPane.showMessageDialog(null, "List already created", "List already created", JOptionPane.INFORMATION_MESSAGE);
                    createNewList = JOptionPane.showInputDialog(null, "Give name for new favourite list");
                    listCounter=-1;         //Για να ξεκιναει ο ελεγχος καθε φορα απο την αρχη της λιστας
                    if (createNewList == null || createNewList.isEmpty()){
                        JOptionPane.showMessageDialog(null, "You must enter a name to create a list", "Enter name for list", JOptionPane.INFORMATION_MESSAGE);
                        createNewList = JOptionPane.showInputDialog(null, "Give name for new favourite list");
                    } 
                }
                listCounter++;
            }
        }
        
        
        em.getTransaction().begin();
        list = new FavoriteList(createNewList);
        favoriteList.add(createNewList);
        em.persist(list);                               //περασμα FavoriteList στην βαση
        em.getTransaction().commit();
    }//GEN-LAST:event_CreateListButtonActionPerformed

    private void ProcessListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessListButtonActionPerformed
        // TODO add your handling code here:
        
        //αν εχει επιλεγει καποια FavoriteList 
        if (listFromjListChoosed == true){
            //θεση του ονοματος της επιλεγμενης FavoriteList
            int index = FavouriteListJList.getSelectedIndex();   
            //ονομα επιλεγμενης FavoriteList
            String selectedList = FavouriteListJList.getSelectedValue();    //ονομα επιλεγμενης λιστας
            FavoriteList selectedListName = new FavoriteList();            
            
            //δημιουργια αντικειμενου FavoriteList με στοιχεια αυτα του ονοματος που επιλεχθηκε
            try {
                selectedListName = DBUtils.getFavoriteListEtityFromFavoriteListName(selectedList);
            } catch (Exception ex) {
                Logger.getLogger(FavouriteListFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //νεο ονομα που εδωσε ο χρηστης
            String existingListNewName = JOptionPane.showInputDialog("Change favourite's list name?" , FavouriteListJList.getSelectedValue());
            //νεο αντικειμενο FavoriteList με ID αυτο που ειχε επιλεξει ο χρηστης αρχικα και ονομα το νεο ονομα που εδωσε ο χρηστης
            FavoriteList newListName = new FavoriteList(selectedListName.getFavoriteListId(), existingListNewName);

            em.getTransaction().begin();
            favoriteList.remove(selectedList);              //διαγραφη απο τη λιστα προς εμφανιση της επιλεγμενης FavoriteList
            favoriteList.add(index, existingListNewName);   //τοποθετηση στην ιδια θεση την νεα FavoriteList(νεο ονομα)    
            em.merge(newListName);                          //συγχωνευση αλλαγων και περασμα στην βαση
            em.getTransaction().commit();
        }
    }//GEN-LAST:event_ProcessListButtonActionPerformed

    private void DeleteListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteListButtonActionPerformed
        // TODO add your handling code here:
        if (listFromjListChoosed == true){
            //λιστα με τις FavoriteLists που θα διαγραφουν
            List<FavoriteList> selectedListsToBeDeleted = new ArrayList<>();  
            //Λιστα με τις επιλεγμενες FavoriteLists απο τον χρηστη
            List<String> selectedLists = FavouriteListJList.getSelectedValuesList(); 
            //προσωρινη αποθηκευση FavoriteList
            FavoriteList tempFavoriteList = new FavoriteList();                          
            
            //για καθε επιλεγμενη απο τον χρηστη FavoriteList
            for(int i=0;i<selectedLists.size();i++){
                try{
                     //δημιουργια αντικειμενου FavoriteList απο καθε ονομα FavoriteList που εχει πατησει ο χρηστης
                    tempFavoriteList = DBUtils.getFavoriteListEtityFromFavoriteListName(selectedLists.get(i)); 
                    //προσθηκη της δημιουργημενης FavoriteList στην λιστα με τις FavoriteLists προς διαγραφη
                    selectedListsToBeDeleted.add(tempFavoriteList);     
                }catch (Exception ex) {
                    Logger.getLogger(FavouriteListFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            int confirm = JOptionPane.showOptionDialog(null, "Delete favourite list?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
            //αν εχει επιλεξει ο χρηστης ναι, για καθε FavoriteList απο αυτες που εχει επιλεξει
            if (confirm==0){                        
                for(int i=0;i<favoriteList.size();i++){
                    favoriteList.remove(selectedLists.get(i));      //αφαιρεση FavoriteList απο την λιστα
                    em.getTransaction().begin();
                    //κανω merge με ενα νεο αντικειμενο τυπου FavoriteList για να γινει μετα η διαγραφη του
                    FavoriteList list2 = em.merge(selectedListsToBeDeleted.get(i));         
                    em.remove(list2);                               //διαγραφη της FavoriteList απο τις λιστες
                    em.getTransaction().commit();
                }
            }
        }
    }//GEN-LAST:event_DeleteListButtonActionPerformed

    private void FavouriteListJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FavouriteListJListMouseClicked
        // TODO add your handling code here:
        listFromjListChoosed = true;
        FavouriteListTableJPanel.setVisible(true);
        
        //ονομα FavoriteList που πατησε ο χρηστης
        String favoriteListFromjList = FavouriteListJList.getSelectedValue();
        
        //αντικειμενο τυπου FavoriteList βασει της επιλογης του χρηστη
        FavoriteList listFromjList = new FavoriteList();
        try {
            listFromjList = DBUtils.getFavoriteListEtityFromFavoriteListName(favoriteListFromjList);
        } catch (Exception ex) {
            Logger.getLogger(FavouriteListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //αν η επιλεγμενη FavoriteList δεν εχει Movies τοτε δεν εχουμε σειρες στον πινακα αφου δεν υπαρχει κατι προς εμφανιση
        if(listFromjList.getMovieList().isEmpty()){
            ((DefaultTableModel) favouriteListComponentsJTable.getModel()).setRowCount(0);
        }else{
            //αν η επιλεγμενη FavoriteList εχει ταινιες τοτε ο πινακας εχει οσες σειρες ειναι και οι Movies που περιεχει
            ((DefaultTableModel) favouriteListComponentsJTable.getModel()).setRowCount(listFromjList.getMovieList().size());
        
            //περασμα στοιχειων Movies που περιεχει η FavoriteList μεσα στον πινακα
            for (int rowCounter=0; rowCounter<listFromjList.getMovieList().size(); rowCounter++){
                favouriteListComponentsJTable.setValueAt(listFromjList.getMovieList().get(rowCounter).getMovieName(), rowCounter, 0);
                favouriteListComponentsJTable.setValueAt(listFromjList.getMovieList().get(rowCounter).getMovieRating(), rowCounter, 1);
                favouriteListComponentsJTable.setValueAt(listFromjList.getMovieList().get(rowCounter).getMovieOverview(), rowCounter, 2);
            }
        }
    }//GEN-LAST:event_FavouriteListJListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateListButton;
    private javax.swing.JButton DeleteListButton;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JList<String> FavouriteListJList;
    private javax.swing.JPanel FavouriteListTableJPanel;
    private javax.swing.JScrollPane FavouriteListsJList;
    private javax.swing.JLabel FavouriteListsLabel;
    private javax.swing.JMenuItem InitialScreenMenuItem;
    private javax.swing.JPanel ListManagementJPanel;
    private javax.swing.JMenuItem MovieSearchMenuItem;
    private javax.swing.JButton ProcessListButton;
    private javax.swing.JMenuItem StatiticsMenuItem;
    private java.util.List<model.FavoriteList> favoriteListList;
    private javax.persistence.Query favoriteListQuery;
    private javax.swing.JTable favouriteListComponentsJTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel_Empty;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.persistence.EntityManager myMovies_newPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
