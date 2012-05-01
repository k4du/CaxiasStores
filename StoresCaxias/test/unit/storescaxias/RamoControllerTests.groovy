package storescaxias



import org.junit.*
import grails.test.mixin.*

@TestFor(RamoController)
@Mock(Ramo)
class RamoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/ramo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ramoInstanceList.size() == 0
        assert model.ramoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.ramoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ramoInstance != null
        assert view == '/ramo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/ramo/show/1'
        assert controller.flash.message != null
        assert Ramo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/ramo/list'


        populateValidParams(params)
        def ramo = new Ramo(params)

        assert ramo.save() != null

        params.id = ramo.id

        def model = controller.show()

        assert model.ramoInstance == ramo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/ramo/list'


        populateValidParams(params)
        def ramo = new Ramo(params)

        assert ramo.save() != null

        params.id = ramo.id

        def model = controller.edit()

        assert model.ramoInstance == ramo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/ramo/list'

        response.reset()


        populateValidParams(params)
        def ramo = new Ramo(params)

        assert ramo.save() != null

        // test invalid parameters in update
        params.id = ramo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/ramo/edit"
        assert model.ramoInstance != null

        ramo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/ramo/show/$ramo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        ramo.clearErrors()

        populateValidParams(params)
        params.id = ramo.id
        params.version = -1
        controller.update()

        assert view == "/ramo/edit"
        assert model.ramoInstance != null
        assert model.ramoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/ramo/list'

        response.reset()

        populateValidParams(params)
        def ramo = new Ramo(params)

        assert ramo.save() != null
        assert Ramo.count() == 1

        params.id = ramo.id

        controller.delete()

        assert Ramo.count() == 0
        assert Ramo.get(ramo.id) == null
        assert response.redirectedUrl == '/ramo/list'
    }
}
