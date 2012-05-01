package storescaxias

import org.springframework.dao.DataIntegrityViolationException

class ProdutoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [produtoInstanceList: Produto.list(params), produtoInstanceTotal: Produto.count()]
    }

    def create() {
        [produtoInstance: new Produto(params)]
    }

    def save() {
        def produtoInstance = new Produto(params)
        if (!produtoInstance.save(flush: true)) {
            render(view: "create", model: [produtoInstance: produtoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'produto.label', default: 'Produto'), produtoInstance.id])
        redirect(action: "show", id: produtoInstance.id)
    }

    def show() {
        def produtoInstance = Produto.get(params.id)
        if (!produtoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "list")
            return
        }

        [produtoInstance: produtoInstance]
    }

    def edit() {
        def produtoInstance = Produto.get(params.id)
        if (!produtoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "list")
            return
        }

        [produtoInstance: produtoInstance]
    }

    def update() {
        def produtoInstance = Produto.get(params.id)
        if (!produtoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (produtoInstance.version > version) {
                produtoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'produto.label', default: 'Produto')] as Object[],
                          "Another user has updated this Produto while you were editing")
                render(view: "edit", model: [produtoInstance: produtoInstance])
                return
            }
        }

        produtoInstance.properties = params

        if (!produtoInstance.save(flush: true)) {
            render(view: "edit", model: [produtoInstance: produtoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'produto.label', default: 'Produto'), produtoInstance.id])
        redirect(action: "show", id: produtoInstance.id)
    }

    def delete() {
        def produtoInstance = Produto.get(params.id)
        if (!produtoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "list")
            return
        }

        try {
            produtoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'produto.label', default: 'Produto'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
