# cloudbees2tech

App to be created 

1.I want to board a train from London to France. The train ticket will cost $20.
2.Create API where you can submit a purchase for a ticket. Details included in the receipt are:
From, To, User , price paid.
3.User should include first and last name, email address
4.The user is allocated a seat in the train. Assume the train has only 2 sections, section A and section B.
5.An API that shows the details of the receipt for the user
6.An API that lets you view the users and seat they are allocated by the requested section
7.An API to remove a user from the train
8.An API to modify a user's seat

Sample output
java code available in TrainTicket.java

Welcome to the Train Ticket System!
From: london
To: france
First Name: deva
Last Name: bala
Email: mailtodeva23@gmail.com
Price Paid: $20
Enter user email for seat assignment: mailtodeva23@gmail.com
Section (A/B): A
Seat: 12
Do you want to add another user? (yes/no): yes
From: london
To: france
First Name: bala
Last Name: deva
Email: mailto@gmail.com
Price Paid: $20
Enter user email for seat assignment: mailto@gmail.com
Section (A/B): B
Seat: 1
Do you want to add another user? (yes/no): no
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
3
All Users and Their Seats:
User: deva bala
Email: mailtodeva23@gmail.com
Section: A
Seat: 12
-------------
User: bala deva
Email: mailto@gmail.com
Section: B
Seat: 1
-------------
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
2
Enter user email for receipt: mailto@gmail.com
Receipt Details:
From: london
To: france
User: bala deva
Email: mailto@gmail.com
Price Paid: $20
Section: B
Seat: 1
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
4
Enter user email for seat modification: mailtodeva23@gmail.com
Enter new seat: 3
Seat for user mailtodeva23@gmail.com has been modified to 3
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
2
Enter user email for receipt: mailtodeva23@gmail.com
Receipt Details:
From: london
To: france
User: deva bala
Email: mailtodeva23@gmail.com
Price Paid: $20
Section: A
Seat: 3
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
5
Enter user email for removal: mailto@gmail.com
User has been Removed Successfully
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
3
All Users and Their Seats:
User: deva bala
Email: mailtodeva23@gmail.com
Section: A
Seat: 3
-------------
Choose an operation
1.View user by section
2.Print receipt
3.Display All users
4.Modify user seat
5.Remove user
6. Exit
