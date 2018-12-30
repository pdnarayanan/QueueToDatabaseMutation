
package com.narayan.test.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Person
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "firstName",
    "lastName",
    "address1",
    "address2",
    "city",
    "state",
    "zip",
    "email"
})
public class Employee {

    /**
     *  The id 
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription(" The id ")
    private Integer id;
    /**
     * The employee's first name.
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("The employee's first name.")
    private String firstName;
    /**
     * The employee's last name.
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("The employee's last name.")
    private String lastName;
    /**
     * The address 1
     * 
     */
    @JsonProperty("address1")
    @JsonPropertyDescription("The address 1")
    private String address1;
    /**
     * The address 2
     * 
     */
    @JsonProperty("address2")
    @JsonPropertyDescription("The address 2")
    private String address2;
    /**
     * The address city
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("The address city")
    private String city;
    /**
     * The address state
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("The address state")
    private String state;
    /**
     * The address zip
     * 
     */
    @JsonProperty("zip")
    @JsonPropertyDescription("The address zip")
    private String zip;
    /**
     * The employees email
     * 
     */
    @JsonProperty("email")
    @JsonPropertyDescription("The employees email")
    private String email;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *  The id 
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     *  The id 
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * The employee's first name.
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The employee's first name.
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * The employee's last name.
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * The employee's last name.
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * The address 1
     * 
     */
    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    /**
     * The address 1
     * 
     */
    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * The address 2
     * 
     */
    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    /**
     * The address 2
     * 
     */
    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * The address city
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * The address city
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The address state
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * The address state
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * The address zip
     * 
     */
    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    /**
     * The address zip
     * 
     */
    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * The employees email
     * 
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * The employees email
     * 
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Employee.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("address1");
        sb.append('=');
        sb.append(((this.address1 == null)?"<null>":this.address1));
        sb.append(',');
        sb.append("address2");
        sb.append('=');
        sb.append(((this.address2 == null)?"<null>":this.address2));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null)?"<null>":this.city));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("zip");
        sb.append('=');
        sb.append(((this.zip == null)?"<null>":this.zip));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.zip == null)? 0 :this.zip.hashCode()));
        result = ((result* 31)+((this.firstName == null)? 0 :this.firstName.hashCode()));
        result = ((result* 31)+((this.lastName == null)? 0 :this.lastName.hashCode()));
        result = ((result* 31)+((this.address2 == null)? 0 :this.address2 .hashCode()));
        result = ((result* 31)+((this.city == null)? 0 :this.city.hashCode()));
        result = ((result* 31)+((this.address1 == null)? 0 :this.address1 .hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.state == null)? 0 :this.state.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Employee) == false) {
            return false;
        }
        Employee rhs = ((Employee) other);
        return (((((((((((this.zip == rhs.zip)||((this.zip!= null)&&this.zip.equals(rhs.zip)))&&((this.firstName == rhs.firstName)||((this.firstName!= null)&&this.firstName.equals(rhs.firstName))))&&((this.lastName == rhs.lastName)||((this.lastName!= null)&&this.lastName.equals(rhs.lastName))))&&((this.address2 == rhs.address2)||((this.address2 != null)&&this.address2 .equals(rhs.address2))))&&((this.city == rhs.city)||((this.city!= null)&&this.city.equals(rhs.city))))&&((this.address1 == rhs.address1)||((this.address1 != null)&&this.address1 .equals(rhs.address1))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.state == rhs.state)||((this.state!= null)&&this.state.equals(rhs.state))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))));
    }

}
