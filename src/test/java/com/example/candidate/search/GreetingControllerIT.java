package com.example.candidate.search;
// @RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// public class AppControllerIntegrationTest {
 
//     @LocalServerPort
//     private int port;
 
//     private String uri;
 
//     @PostConstruct
//     public void init() {
//         uri = "http://localhost:" + port;
//     }
 
//     @MockBean
//     AppService appService;
 
//     @Test
//     public void givenMovieId_whenMakingGetRequestToMovieEndpoint_thenReturnMovie() {
 
//     Movie testMovie = new Greeting(1, "Hello, Max");
//     when(appService.findMovie(1)).thenReturn(testMovie);
 
//     get(uri + "/movie/" + testMovie.getId()).then()
//       .assertThat()
//       .statusCode(HttpStatus.OK.value())
//       .body("id", equalTo(testMovie.getId()))
//       .body("name", equalTo(testMovie.getName()))
//       .body("synopsis", notNullValue());
// }