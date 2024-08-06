package com.cavenaire.notesmanager.model;

/**
 * Represents a juridical or natural client model with basic information.
 */
public interface ClientModel {
    /**
     * Sets client name.
     *
     * @param name the name
     */
    void setName(String name);

    /**
     * Gets client name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets client document identification (V-XX.XXX.XXX or J-XXXXXXXX-X).
     *
     * @param document the document
     */
    void setDocument(String document);

    /**
     * Gets client document identification (V-XX.XXX.XXX or J-XXXXXXXX-X).
     *
     * @return the document
     */
    String getDocument();

    /**
     * Sets client phone number contact (0XXX-XXXXXXX).
     *
     * @param contact the contact
     */
    void setContact(String contact);

    /**
     * Gets client phone number contact (0XXX-XXXXXXX).
     *
     * @return the contact
     */
    String getContact();

    /**
     * Sets client address.
     *
     * @param address the address
     */
    void setAddress(String address);

    /**
     * Gets client address.
     *
     * @return the address
     */
    String getAddress();

    /**
     * Sets client latest date interaction.
     *
     * @param lastDate the last date
     */
    void setLastDate(String lastDate);

    /**
     * Gets client latest date interaction.
     *
     * @return the last date
     */
    String getLastDate();

    /**
     * Gets client database id.
     *
     * @return the id
     */
    int getID();

    /**
     * Say if the client is a juridical type (not natural).
     *
     * @return the boolean
     */
    boolean isJuridical();

    /**
     * Say if the client is a natural type (not juridical).
     *
     * @return the boolean
     */
    boolean isNatural();
}

