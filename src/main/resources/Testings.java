

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testing {
	@Autowired
	private CartSerices servicess;
	
	@Mockbean
	private AddtoCart addcart;
	
	@Test
	public void getUsersTest() {
		when(repository.findall()).thenReturn(Stream)
	}
	

}
