package storescaxias

import org.springframework.dao.DataIntegrityViolationException

class RamoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ramoInstanceList: Ramo.list(params), ramoInstanceTotal: Ramo.count()]
    }

    def create() {
        [ramoInstance: new Ramo(params)]
    }

    def save() {
        def ramoInstance = new Ramo(params)
        if (!ramoInstance.save(flush: true)) {
            render(view: "create", model: [ramoInstance: ramoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'ramo.label', default: 'Ramo'), ramoInstance.id])
        redirect(action: "show", id: ramoInstance.id)
    }

    def show() {
        def ramoInstance = Ramo.get(params.id)
        if (!ramoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "list")
            return
        }

        [ramoInstance: ramoInstance]
    }

    def edit() {
        def ramoInstance = Ramo.get(params.id)
        if (!ramoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "list")
            return
        }

        [ramoInstance: ramoInstance]
    }

    def update() {
        def ramoInstance = Ramo.get(params.id)
        if (!ramoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (ramoInstance.version > version) {
                ramoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ramo.label', default: 'Ramo')] as Object[],
                          "Another user has updated this Ramo while you were editing")
                render(view: "edit", model: [ramoInstance: ramoInstance])
                return
            }
        }

        ramoInstance.properties = params

        if (!ramoInstance.save(flush: true)) {
            render(view: "edit", model: [ramoInstance: ramoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'ramo.label', default: 'Ramo'), ramoInstance.id])
        redirect(action: "show", id: ramoInstance.id)
    }

    def delete() {
        def ramoInstance = Ramo.get(params.id)
        if (!ramoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "list")
            return
        }

        try {
            ramoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ramo.label', default: 'Ramo'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
