
package org.world.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.world.model.Country;

/**
 *
 * @author louzar
 */
@Entity
@Table(name = "country_ln")
@NamedQueries({
    @NamedQuery(name = "CountryLn.findAll", query = "SELECT c FROM CountryLn c")})
public class CountryLn implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Country country;
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Language language;

    public CountryLn() {
    }

    public CountryLn(Integer id) {
        this.id = id;
    }

    public CountryLn(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
        if (!(object instanceof CountryLn)) {
            return false;
        }
        CountryLn other = (CountryLn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
	public String toString() {
		return "CountryLn [id=" + id + ", name=" + name + ", country="
				+ country + ", language=" + language + "]";
	}
    
}
