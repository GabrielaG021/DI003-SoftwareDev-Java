//File for use in Ajax lesson
$(document).ready(function () {
  $.ajax({
    type: "GET",
    url: "http://contactlist.us-east-1.elasticbeanstalk.com/contacts",
    success: function (contactArray) {
      // Create a variable to use jQuery to connect it to the allContacts div in html page
      var contactsDiv = $("#allContacts");

      // Add All Contacts
      $.each(contactArray, function (index, contact) {
        // Open a new paragraph (<p>) for each record.
        var contactInfo = "<p>";
        // Add the label Name to the first line, concatenated with the contact's first and last names
        contactInfo +=
          "Name: " + contact.firstName + " " + contact.lastName + "<br>";
        // Add the label Company to the next line, along with the name of the business.
        // Do the same for email and phone.
        contactInfo += "Company: " + contact.company + "<br>";
        contactInfo += "Email: " + contact.email + "<br>";
        contactInfo += "Phone: " + contact.phone + "<br>";
        // Close the paragraph and add a horizontal rule.
        contactInfo += "</p><hr>";

        // Append the resulting string to contactInfo
        contactsDiv.append(contactInfo);
      });
    },
    error: function () {
      alert("FAILURE!");
    },
  });
});
