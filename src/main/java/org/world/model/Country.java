
package org.world.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @Column(name = "capital_name", nullable = false, length = 32)
    private String capitalName;
    @Basic(optional = false)
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @Column(name = "modification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country" , fetch= FetchType.EAGER)
    private List<CountryLn> countryLnList;
    @JoinColumn(name = "created_by", referencedColumnName = "username", nullable = false)
    @OneToOne(optional = false)
    private Users createdBy;
    @JoinColumn(name = "modified_by", referencedColumnName = "username", nullable = false)
    @OneToOne(optional = false)
    private Users modifiedBy;

    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
    }

    public Country(String code, long populationCount, String capitalName) {
        this.code = code;
        this.populationCount = populationCount;
        this.capitalName = capitalName;

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

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
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

    public List<CountryLn> getCountryLnList() {
        return countryLnList;
    }

    public void setCountryLnList(List<CountryLn> countryLnList) {
        this.countryLnList = countryLnList;
    }

    public Users getUsers() {
        return createdBy;
    }

    public void setUsers(Users users) {
        this.createdBy = users;
    }

    public Users getUsers1() {
        return modifiedBy;
    }

    public void setUsers1(Users users1) {
        this.modifiedBy = users1;
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
				+ populationCount + ", capitalName=" + capitalName
				+ ", creationDate=" + creationDate + ", modificationDate="
				+ modificationDate + ", countryLnList=" + countryLnList
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ "]";
	}
    
}
