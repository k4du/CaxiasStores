package storescaxias



import org.junit.*
import grails.test.mixin.*

@TestFor(UsuarioController)
@Mock(Usuario)
class UsuarioControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/usuario/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.usuarioInstanceList.size() == 0
        assert model.usuarioInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.usuarioInstance != null
    }

    void testSave() {
        controller.save()

        assert model.usuarioInstance != null
        assert view == '/usuario/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/usuario/show/1'
        assert controller.flash.message != null
        assert Usuario.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/usuario/list'


        populateValidParams(params)
        def usuario = new Usuario(params)

        assert usuario.save() != null

        params.id = usuario.id

        def model = controller.show()

        assert model.usuarioInstance == usuario
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/usuario/list'


        populateValidParams(params)
        def usuario = new Usuario(params)

        assert usuario.save() != null

        params.id = usuario.id

        def model = controller.edit()

        assert model.usuarioInstance == usuario
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/usuario/list'

        response.reset()


        populateValidParams(params)
        def usuario = new Usuario(params)

        assert usuario.save() != null

        // test invalid parameters in update
        params.id = usuario.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/usuario/edit"
        assert model.usuarioInstance != null

        usuario.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/usuario/show/$usuario.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        usuario.clearErrors()

        populateValidParams(params)
        params.id = usuario.id
        params.version = -1
        controller.update()

        assert view == "/usuario/edit"
        assert model.usuarioInstance != null
        assert model.usuarioInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/usuario/list'

        response.reset()

        populateValidParams(params)
        def usuario = new Usuario(params)

        assert usuario.save() != null
        assert Usuario.count() == 1

        params.id = usuario.id

        controller.delete()

        assert Usuario.count() == 0
        assert Usuario.get(usuario.id) == null
        assert response.redirectedUrl == '/usuario/list'
    }
}
