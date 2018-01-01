db.restaurants.find().pretty();

db.restaurants.find({} , {restaurant_id : 1 , name : 1 , borough : 1 , cuisine : 1 , _id : 0}).pretty();

db.restaurants.find({borough : "Bronx"} , {restaurant_id : 1 , name : 1 , borough : 1 , cuisine : 1 , _id : 0}).pretty();

db.restaurants.find({"grades.score" : {$gt : 75 , $lt : 100}} , {}).pretty();
//ou
db.restaurants.find({grades : {$elemMatch : {score : {$gt : 75 , $lt : 100}}}} , {}).pretty();

db.restaurants.find({$and : {borough : "Queens", $name : {$regex : /er$/}}}, {restaurant_id : 1 , name : 1 , cuisine : 1 , _id : 0}).pretty();

db.restaurants.find({borough : "Queens", name : {$regex : /er$/}}, {restaurant_id : 1 , name : 1 , cuisine : 1 , _id : 0}).pretty();

db.restaurants.find({"grades.score" : {$lte : 5}},{_id : 0 , id : 1 , name : 1, score : 1});

db.restaurants.find({cuisine : "Bakery"}).sort({"grades.score" : -1}).pretty();


db.restaurants.updateMany({borough :  "Queens", cuisine : "American"}, {$set : { cuisine :  "Primer American Food"}});

db.restaurants.find({"address.coord" : []}).pretty();

db.restaurants.insert({ name : "Silêncio Bistro", city : "Braga", cuisine : "Mediterranea", restaurant_id : "123134"});

db.restaurants.remove({city : "Braga"});
