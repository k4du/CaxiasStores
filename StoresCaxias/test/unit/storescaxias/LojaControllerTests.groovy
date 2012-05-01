package storescaxias



import org.junit.*
import grails.test.mixin.*

@TestFor(LojaController)
@Mock(Loja)
class LojaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/loja/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.lojaInstanceList.size() == 0
        assert model.lojaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.lojaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.lojaInstance != null
        assert view == '/loja/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/loja/show/1'
        assert controller.flash.message != null
        assert Loja.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/loja/list'


        populateValidParams(params)
        def loja = new Loja(params)

        assert loja.save() != null

        params.id = loja.id

        def model = controller.show()

        assert model.lojaInstance == loja
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/loja/list'


        populateValidParams(params)
        def loja = new Loja(params)

        assert loja.save() != null

        params.id = loja.id

        def model = controller.edit()

        assert model.lojaInstance == loja
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/loja/list'

        response.reset()


        populateValidParams(params)
        def loja = new Loja(params)

        assert loja.save() != null

        // test invalid parameters in update
        params.id = loja.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/loja/edit"
        assert model.lojaInstance != null

        loja.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/loja/show/$loja.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        loja.clearErrors()

        populateValidParams(params)
        params.id = loja.id
        params.version = -1
        controller.update()

        assert view == "/loja/edit"
        assert model.lojaInstance != null
        assert model.lojaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/loja/list'

        response.reset()

        populateValidParams(params)
        def loja = new Loja(params)

        assert loja.save() != null
        assert Loja.count() == 1

        params.id = loja.id

        controller.delete()

        assert Loja.count() == 0
        assert Loja.get(loja.id) == null
        assert response.redirectedUrl == '/loja/list'
    }
}
