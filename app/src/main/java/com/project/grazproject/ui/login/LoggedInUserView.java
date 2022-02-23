package com.project.grazproject.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 * Class gets ant translates user's name to welcome page
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}