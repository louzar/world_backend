
package org.world.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author louzar
 */
@Entity
@IdClass(CountryLn.class)
@Table(name = "country_ln")
@NamedQueries({
    @NamedQuery(name = "CountryLn.findAll", query = "SELECT c FROM CountryLn c")})
public class CountryLn implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 32)
    private String name;
    @Basic(optional = false)
    @Column(name = "capital_name", nullable = false, length = 32)
    private String capitalName;
    @Id
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Country country;
    @Id
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch=FetchType.LAZY)
    private Language language;

    public CountryLn() {
    }



    public CountryLn(String name, String capitalName) {
        this.name = name;
        this.capitalName = capitalName;
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
	public String toString() {
		return "CountryLn [name=" + name + ", country="
				+ country + ", language=" + language + "]";
	}



	public String getCapitalName() {
		return capitalName;
	}



	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
    
}
