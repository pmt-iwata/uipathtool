package jp.co.pmtech.iwata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UiPathFolderDto {
    
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("FullyQualifiedName")
    private String fullyQualifiedName;
    @JsonProperty("FullyQualifiedNameOrderable")
    private String fullyQualifiedNameOrderable;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ProvisionType")
    private String provisionType;
    @JsonProperty("PermissionModel")
    private String permissionModel;
    @JsonProperty("ParentId")
    private String parentId;
    @JsonProperty("IsActive")
    private String isActive;
    @JsonProperty("Id")
    private String id;

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }
    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }
    public String getFullyQualifiedNameOrderable() {
        return fullyQualifiedNameOrderable;
    }
    public void setFullyQualifiedNameOrderable(String fullyQualifiedNameOrderable) {
        this.fullyQualifiedNameOrderable = fullyQualifiedNameOrderable;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProvisionType() {
        return provisionType;
    }
    public void setProvisionType(String provisionType) {
        this.provisionType = provisionType;
    }
    public String getPermissionModel() {
        return permissionModel;
    }
    public void setPermissionModel(String permissionModel) {
        this.permissionModel = permissionModel;
    }
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getIsActive() {
        return isActive;
    }
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
