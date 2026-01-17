#steps to send email using jakatra api
    1.Step create folder hiarchey like this javalab/
                                                   -lib/
                                                        -jakarta.mail.jar
                                                        -jakarta.activation.jar
                                                    -SendingEmail.java
  2.download 2 api inside lib folder 
  3.copy code and see comments and put ur own email and app password
  3.to get app password u need to have 2FA (See on youtube or chatgpt)
  4.put subject and text in code of ur own 
 (windows only) 5.to compile into class file open terminal and paste: javac -cp ".;lib/*" SendingEmail.java 
  6.to run class file paste: java -cp ".;lib/*" SendingEmail
  the email will be sent successfully
for mac:
 5. to compile into class file open terminal and paste: javac -cp ".:lib/*" SendingEmail.java
   6.to run class file paste: java -cp ".:lib/*" SendingEmail
  the email will be sent successfully
