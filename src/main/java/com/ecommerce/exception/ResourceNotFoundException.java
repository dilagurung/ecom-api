package com.ecommerce.exception;

/**
 * Created by oa on 1/23/2018.
 */
public class ResourceNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1791564636123821495L;
    private Long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.setResourceId(resourceId);
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
