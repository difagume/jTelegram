/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Fouad Almalki
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.fouad.jtb.core.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * This object represents a Telegram user or bot.
 */
public class User {

    /**
     * Unique identifier for this user or bot.
     */
    @JsonProperty("id")
    private int id;

    @JsonProperty("is_bot")
    private boolean isBot;

    /**
     * User‘s or bot’s first name.
     */
    @JsonProperty("first_name")
    private String firstName;

    /**
     * Optional. User‘s or bot’s last name.
     */
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Optional. User‘s or bot’s username.
     */
    @JsonProperty("username")
    private String username;

    @JsonProperty("language_code")
    private String languageCode;

    public User() {
    }

    public User(int id, boolean isBot, String firstName, String lastName, String username, String languageCode) {
        this.id = id;
        this.isBot = isBot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.languageCode = languageCode;
    }

    public int getId() {
        return id;
    }

    public boolean isIsBot() {
        return isBot;
    }

    public void setIsBot(boolean isBot) {
        this.isBot = isBot;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        User user = (User) o;
//
//        if (id != user.id) {
//            return false;
//        }
//        if (isBot != user.isBot) {
//            return false;
//        }
//        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) {
//            return false;
//        }
//        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) {
//            return false;
//        }
//        return username != null ? username.equals(user.username) : user.username == null;
//
//    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.isBot != other.isBot) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.languageCode, other.languageCode)) {
            return false;
        }
        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + (username != null ? username.hashCode() : 0);
//        return result;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + (this.isBot ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.languageCode);
        return hash;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + "isBot=" + isBot
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", username='" + username + '\''
                + ", languageCode='" + languageCode + '\''
                + '}';
    }
}
