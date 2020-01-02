package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

type Person struct {
	Name     string `json:"name"`
	Age      int64
	FavColor string `json:"favorite_color"`
}
type Persons []Person

var AllPerson = Persons{}

var myMap = map[string]Person{
	"abc": {
		Name: "abc", Age: 25, FavColor: "Black",
	},
	"def": {
		Name: "def", Age: 34, FavColor: "Yellow",
	},
}

/*var AllPerson = Persons{
	{
		Name: "abc", Age: 25, FavColor: "Black",
	},
	{
		Name: "def", Age: 34, FavColor: "Yellow",
	},
}
*/

func homeLink(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Welcome home!")
}
func createPerson(w http.ResponseWriter, r *http.Request) {
	var newEvent Person
	reqBody, err := ioutil.ReadAll(r.Body)
	if err != nil {
		fmt.Fprintf(w, "Kindly enter data with the event title and description only in order to update")
	}

	json.Unmarshal(reqBody, &newEvent)
	//AllPerson = append(AllPerson, newEvent)
	myMap[newEvent.Name] = newEvent
	w.WriteHeader(http.StatusCreated)

	json.NewEncoder(w).Encode(newEvent)
}
func getOnePerson(w http.ResponseWriter, r *http.Request) {
	NameParam := mux.Vars(r)["name"]
	v1 := myMap[NameParam]

	if len(v1.Name) != 0 && v1.Age != 0 && len(v1.FavColor) != 0 {
		SinglePerson, _ := json.Marshal(v1)
		w.Write(SinglePerson)
	}

	/*for _, singlePerson := range AllPerson {
		if singlePerson.Name == NameParam {
			SinglePerson, _ := json.Marshal(singlePerson)
			w.Write(SinglePerson)
			//json.NewEncoder(w).Encode(singlePerson)
		}
	}*/
}

func getAllPerson(w http.ResponseWriter, r *http.Request) {

	var AllPerson = Persons{}
	for _, value := range myMap {
		if len(value.Name) != 0 && value.Age != 0 && len(value.FavColor) != 0 {
			AllPerson = append(AllPerson, value)
		}

	}
	AllMarshaledPerson, _ := json.Marshal(AllPerson)
	file, _ := json.MarshalIndent(AllPerson, "", " ")

	_ = ioutil.WriteFile("test12.json", file, 0644)
	w.Write(AllMarshaledPerson)

}

func main() {
	router := mux.NewRouter().StrictSlash(true)

	router.HandleFunc("/people", createPerson).Methods("POST")
	router.HandleFunc("/people/{name}", getOnePerson).Methods("GET")
	router.HandleFunc("/people", getAllPerson)
	log.Fatal(http.ListenAndServe(":8081", router))
}
