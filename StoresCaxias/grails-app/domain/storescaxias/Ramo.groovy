package storescaxias

import groovy.transform.ToString;

class Ramo {
	String  nome
	static hasMany = [ lojas:Loja]
    static constraints = {
    }
	
	String toString = {
		return nome
	}
}
