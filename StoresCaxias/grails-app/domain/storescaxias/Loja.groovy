package storescaxias

class Loja {
	String nome
	String descricao
	static belongsTo = [ramo : Ramo ]
	static hasMany = [enderecos : Endereco,produtos: Produto]  
	byte[] imagem
    static constraints = {
		imagem(maxSize:1073741824)
    }
}
