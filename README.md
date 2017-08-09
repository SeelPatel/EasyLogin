# EasyLogin
Quick way to create login screen in android

----------------------------------------------------------------------------------------------

Use by placing the easy login xml file in the res/layout folder of your project

Then add the EasyLogin.java file with your source files

----------------------------------------------------------------------------------------------

To create a login screen:

Add this code in the onCreate method of the Login Activity
WARNING: Do not set content view. This may not allow it to display properly

==========================================================================

final EasyLogin loginScreen = new EasyLogin(this,this);
loginScreen.setTheme(EasyLogin.Style.DARK);

loginScreen.setOnLoginListener(new EasyLogin.LoginEventListener() {
  @Override
  public void loginButtonPressed() {

  }
});

loginScreen.initializeLoginScreen();

==========================================================================

