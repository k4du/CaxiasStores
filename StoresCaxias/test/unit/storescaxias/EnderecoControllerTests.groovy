package storescaxias



import org.junit.*
import grails.test.mixin.*

@TestFor(EnderecoController)
@Mock(Endereco)
class EnderecoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/endereco/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.enderecoInstanceList.size() == 0
        assert model.enderecoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.enderecoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.enderecoInstance != null
        assert view == '/endereco/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/endereco/show/1'
        assert controller.flash.message != null
        assert Endereco.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/endereco/list'


        populateValidParams(params)
        def endereco = new Endereco(params)

        assert endereco.save() != null

        params.id = endereco.id

        def model = controller.show()

        assert model.enderecoInstance == endereco
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/endereco/list'


        populateValidParams(params)
        def endereco = new Endereco(params)

        assert endereco.save() != null

        params.id = endereco.id

        def model = controller.edit()

        assert model.enderecoInstance == endereco
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/endereco/list'

        response.reset()


        populateValidParams(params)
        def endereco = new Endereco(params)

        assert endereco.save() != null

        // test invalid parameters in update
        params.id = endereco.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/endereco/edit"
        assert model.enderecoInstance != null

        endereco.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/endereco/show/$endereco.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        endereco.clearErrors()

        populateValidParams(params)
        params.id = endereco.id
        params.version = -1
        controller.update()

        assert view == "/endereco/edit"
        assert model.enderecoInstance != null
        assert model.enderecoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/endereco/list'

        response.reset()

        populateValidParams(params)
        def endereco = new Endereco(params)

        assert endereco.save() != null
        assert Endereco.count() == 1

        params.id = endereco.id

        controller.delete()

        assert Endereco.count() == 0
        assert Endereco.get(endereco.id) == null
        assert response.redirectedUrl == '/endereco/list'
    }
}
