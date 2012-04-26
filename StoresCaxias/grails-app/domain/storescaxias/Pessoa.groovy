package storescaxias

class Pessoa {

	String nome;
	String sobrenome;
	Date dataNasc;
	String toString(){
		nome
	}
	
    static constraints = {
		nome(blank:false,nullable:false)
		sobrenome(blank:false,nullable:false)
		dataNasc(nullable:false)
    }
}
