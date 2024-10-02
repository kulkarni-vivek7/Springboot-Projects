# Springboot-Projects

In This Repository, All Springboot project that i have done will be there.

To Run Any Springboot project project, you have to do some important steps first

  1. If You don't have Spring tool suite 4, install it from here https://spring.io/tools ![Screenshot 2024-10-02 205408](https://github.com/user-attachments/assets/f074850b-3f93-4f62-afc3-51a6b80e58a8) download the software from this section.
  
  2. After installing the software, if you want to create a Springboot project you ca follow the bellow steps,
     
     1. ![Screenshot 2024-10-02 210302](https://github.com/user-attachments/assets/c7cb8e22-cc26-48b4-a385-71956365a1bf)
        select Spring Strater Project Option.
        
     2. ![Screenshot 2024-10-02 210511](https://github.com/user-attachments/assets/c3095363-d828-40f9-bd1a-0328a36a41eb)
        next this window will open and in this provide all the informations like in the image.
        
     3. ![Screenshot 2024-10-02 210815](https://github.com/user-attachments/assets/c3572fd8-e504-437e-b8bb-f7c46bd4538a)
        next this window will open and here you have to add all the necessary dependencies like shown in the above image (note :- if you want to add Lombok                 dependency, you have to first configure it.) and click on finish to create your project.

  
  4. if you already have a springboot project and if you want to import it, Go To File section and there Select "Open Projects From File System..." option and a window will open. In that window on the top-right side a Directory button will be there, click it and select your springboot project folder and then click on Finish button which will be there at bottom-right and your springboot project will be imported.

****Most Important****
before running any springboot project, go to the project that you have imported or created and in the project you can see **src/main/resources** open it and in that select application.properties file. Firstly only one statement will be there, but you have to add the bellow code in that file,

                              spring.datasource.url= jdbc:mysql://localhost:3306/eventmanagementsystem?createDatabaseIfNotExist=true
                              spring.datasource.username=your_mysql_username
                              spring.datasource.password=your_mysql_password
                              
                              spring.jpa.hibernate.ddl-auto=update
                              spring.jpa.properties.hibernate.format_sql=true
                              spring.jpa.show-sql=true
                              
                              spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

after adding the above coee in application.properties file save it and now you can run your project. :)
