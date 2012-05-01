package storescaxias

class Produto {
	String nome
	String descricao
	BigDecimal preco
	byte[] imagem
    static constraints = {
		imagem(maxSize:1073741824)
    }
}
