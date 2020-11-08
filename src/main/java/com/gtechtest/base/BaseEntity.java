package com.gtechtest.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseEntity implements Serializable {
    @Column(name = "CREATED_DT")
    private Date createdDt;

    @Column(name = "MODIFIED_DT")
    private Date modifiedDt;
}
