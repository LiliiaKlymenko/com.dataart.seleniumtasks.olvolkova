package json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "password",
        "roleModel",
        "fname",
        "lname",
        "name"
})
@Generated("jsonschema2pojo")
public class AuthorJson {

    @JsonProperty("password")
    private String password;
    @JsonProperty("roleModel")
    private RoleModelJson roleModel;
    @JsonProperty("fname")
    private String fname;
    @JsonProperty("lname")
    private String lname;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("roleModel")
    public RoleModelJson getRoleModel() {
        return roleModel;
    }

    @JsonProperty("roleModel")
    public void setRoleModel(RoleModelJson roleModel) {
        this.roleModel = roleModel;
    }

    @JsonProperty("fname")
    public String getFname() {
        return fname;
    }

    @JsonProperty("fname")
    public void setFname(String fname) {
        this.fname = fname;
    }

    @JsonProperty("lname")
    public String getLname() {
        return lname;
    }

    @JsonProperty("lname")
    public void setLname(String lname) {
        this.lname = lname;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
