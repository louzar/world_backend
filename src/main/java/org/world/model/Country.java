
package org.world.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author louzar
 */
@Entity
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "code", nullable = false, length = 16)
    private String code;
    @Basic(optional = false)
    @Column(name = "population_count", nullable = false)
    private long populationCount;
    @Basic(optional = false)
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "modification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Users createdBy;
    @JoinColumn(name = "modified_by", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private Users modifiedBy;


    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
    }

    public Country(String code, long populationCount) {
        this.code = code;
        this.populationCount = populationCount;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(long populationCount) {
        this.populationCount = populationCount;
    }


    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Users modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", populationCount="
				+ populationCount 
				+ ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate 
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ "]";
	} 
}
