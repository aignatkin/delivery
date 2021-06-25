package ru.aignatkin.delivery.repository;

@SpringBootTest
public class RespotioryTest {

    @Autowired
    DeliverypointRepository repository;

    @BeforeAll
    public void prepare(){
        //fill data intpo databsae
        DeliveryPoint dp = new DeliveryPoint();

        repository.addDeliveryPoint(dp);
    }

    @Test
    public void  testDataIsRetrievedSuccessfully() {
        List<DeliveryPointDTO> result = repository.findData();
        assertEquals(result.size(), 3);

    }

}
