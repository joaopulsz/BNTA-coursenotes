# Introduction to the Internet

We've all used the internet for something. To read these notes you're either looking at them in a web browser or you opened a file which you downloaded earlier. Add in email, social media, cloud computing and all the other things we can use it for and the internet starts to look like a very big, very scary place. The way in which a lot of these services are implemented can be fairly complex, but the fundamentals which underpin how a system can access the internet are much simpler.

## What is the Internet?

Often when we use the word "internet" the thing we're actually talking about is only a small sub-set of what the internet actually is.

The **internet** was conceived in the 1960s as a networking tool for the US military, enabling them to link computers across multiple sites using phone lines. It existed only as a defence and research tool until commercial applications were developed in the late 1980s, kickstarting its growth into the internet as we know it today.

One of those developments was the **World-Wide Web**, invented by Sir Tim Berners-Lee in 1989. The web represents what we often think of as "the internet" today, enabling us to view content hosted elsewhere almost as if it was saved locally. When we talk about **websites** we are talking about collections of interlinked documents built with specific tools to facilitate user interaction, rather than a group of computers talking to each other. The very first website is [still available to view online](http://info.cern.ch/hypertext/WWW/TheProject.html).


## IP Addresses & Ports

### IP Addresses

The first step in sending a message to another system is knowing which system you're trying to communicate with. When we access a site on the world-wide web we do so by typing the site's address (or **URL** - **U**niform **R**esource **L**ocator) into our browsers. This is a good starting point but only gets us part of the way there, since a computer can't actually make sense of what we typed without a bit of assistance.

Let's think of a real-world comparison. If we wanted to meet up at the Bright Network offices we could say to each other "let's meet at Bright Network", but we likely wouldn't be able to get there with only that information. We need something more specific, like a postcode or a street address. In internet terms, typing "www.brightnetwork.co.uk" is the equivalent of asking to meet at the office. The internet doesn't work in terms of plain text like that, instead each system connected to the internet has a unique numerical representation which is the equivalent of its postcode. 

![Example of an IP address](../../../assets/programming_fundamentals/intro_to_the_web/ip_address.png)

We call these numbers **IP addresses**. When we type an address into our browser the first thing that happens is our computer connects to a special server known as a **DNS** (**D**omain **N**ame **S**ystem) server to fine the corresponding IP address. The DNS server sends back the IP we need which our system then connects to. These numbers are made up of groups of digits separated by dots, a format known as **IPv4**. As the number of websites grows an updated format (**IPv6**) is being phased in which uses a similar structure but allows for larger numbers. 

### Ports

There is a further step to this process, namely deciding which bit of the other system we want to connect to. Every system has tens of thousands of virutal **ports**, gateways where network connections start and end. Returning to our address metaphor, if the IP address is the building number and postcode then the port we are connecting to is the room number inside the building. These ports greatly expand what we are able to do using a single system; we are able to make multiple requests at once to different IP addresses, each originating from a different port on our system. Likewise if we were running a server we could accept multiple requests at once. We can even do both at the same time.

A key benefit of using ports is that different applications running on our system can communicate with each other as if they were on separate machines. By the end of the course we will be able to build a full-stack application consisting of a JavaScript app running on one port and requesting data from a Java app running on another. That Java app will in turn be storing data in a database accessible through its own port, we could even request data from an external resource while all this is going on.

Some ports are reserved for system use or to serve as defaults for certain services and are designated as *well-known ports*. This ensures that programs and services will behave in the expected way and helps to avoid unpleasant surprises for users. For example, the Simple Mail Transfer Protocol will always make connections using port 25, while the secure shell (SSH) remote login protocol uses port 22. Only the first thousand or so ports are in use (or reserved for future use) for such services.

Beyond those we have thousands of ports available for our applications to use. Most frameworks which require use of a port will use a specific one by default, for example Spring Boot apps use port 8080. This means any other application we run can connect to it by making a request through port 8080. Unlike the well-known ports these values can be changed, but with the caveat that moving away from the default can cause problems for other developers and should be well-documented.

### Request-Response cycle

Information passes between systems in the same way regardless of what types of systems are talking to each other. We call this process the **request-response cycle**.

![The request-response cycle](../../../assets/programming_fundamentals/intro_to_the_web/request_response.png)

The system initiating the communication is the **client**, although that does not necessarily mean that there is a human user interacting with the system. The client makes a **request** which must conform to some standard known as a **protocol** (more on them in the next section). Which protocol should be used is determined by the **server** which will receive the request. The exact format will vary depending on the protocol, but typically a request will include both any information the client wishes to send plus *metadata* - information about the request which may be relevant.

The server is responsible for determining what should happen with any request it receives. There far too many possibilities to go into here, but they could range from simply sending back some data to complex bits of business logic. They can (and often do) make their own requests to other services, for example to check a user's login credentials. When the server is ready it sends a **response** to the client using the same protocol. This response will include any data requested by the client, confirmation that a requested action was completed or an error message explaining why not.

## Protocols

When we talk about protocols they sound like a very technical concept, but we actually use them in our day-to-day lives without even thinking about it. For example, when we have a conversation with a colleague there are certain conventions we follow: we don't talk over each other, we don't raise our voices, we don't walk away while the other person is mid-sentence. This collection of rules defines a **protocol** by which we communicate, and in computing they work the same way.

### Internet Protocol

One such protocol is the **Internet Protocol**, which underpins all communication across the internet. It defines the structure of the messages which are sent between systems and the conditions which must be satisfied in order to ensure the integrity of those messages.

Communication using IP is done with **IP packets**. These are used to parcel up the data being sent across the internet with the format being kept consistent regardless of the content. A packet includes information about:

- The packet's origin
- Its destination
- The IP version used to encode it (eg. IPv4)
- A value used to confirm the data's integrity, known as a **checksum**
- The data itself

![Breakdown of a packet](../../../assets/programming_fundamentals/intro_to_the_web/packet.png)

A significant issue with packets is their size - they're only 0.065MB! That's not generally a problem when sending text or HTML, where the content is usually measured in kilobytes, but presents an issue when dealing with other types of media. Consider a photo for example: an image taken using a modern smartphone and uploaded to the internet will typically be about 2MB, far bigger than will fit in a packet. That means we need to break it up before we can send it.

This sounds scary and like a really bad idea but thankfully it's neither once we put it in to practice. That's partially because of how things like photos are stored on our hard drives. Although they appear as a single object on the page they are in fact a collection of characters describing how many pixels there are, where they are located and what colour they should be. Ultimately there is no difference between a photo, a video or a stream of text as far as the computer is concerned, it's all a matter of how they are interpreted by the program opening them (try opening an image using a text editor to see what it looks like). What it means in this context is that it's much easier to split that string of characters apart, send the chunks separately and reassemble them at the other end.

We can be sure that the reassembly happens correctly because of the protocol. Along with the information listed above, the packet's header also includes a sequence number which tells the receiver which order to place the packets in. Assuming the checksums are all fine an image can be broken down into packets, send across the internet and reassembled at the other end as if nothing had happened!

### HTTP

Building on top of the IP is another protocol which most of us are likely to have seen at some point as it forms part of nearly every URL we see in our browsers: the **H**yper-**T**ext **T**ransfer **P**rotocol, or **HTTP**. This protocol still has all of the features of the IP but adds a layer of abstraction above them. This makes it much easier for developers like us to work with and lets us focus more on the content of the requests and responses rather than the low-level implementation details. You may also have come across the **HTTPS** protocol, where the "S" stands for **S**ecure. As you might expect this protocol is used when a degree of encryption is required for the requests.

An HTTP request is split into two parts: the **header** and the **body**. The header includes metadata for the request similar to the details included in a packet, plus some others:

- Origin and destination
- Acceptable formats for the response
- Acceptable languages and encodings for the response
- The **request method**

Request methods are an important tool for servers to help them determine how to handle a request they receive. The request methods are also know as **HTTP verbs** and loosely correspond to what the sender wants to accomplish. For example a`GET` request is used to retrieve information from a server while a `POST` request submits new data to the server. Note that the data is not included in the header, instead it makes up the entirety of the request's body.

An HTTP response follows a similar pattern with metadata in the header and teh requested data (if any) in the body, but this time with the addition in the header of a **status code**. These codes perform a similar role to the HTTP verbs with each having a particular meaning. Some common examples which you may have seen before include:

- `200` - "OK"; Everything worked as expected
- `401` - "Unauthorised"; The server requires some kind of authentication (eg. a password) to access this resource and it hasn't been provided
- `404` - "Not Found"; The server isn't configured to handle a request to this resource
- `503` - "Service Unavailable"; The server can't process the request due to a temporary issue, eg. maintenance

A full list can be found [here](https://www.restapitutorial.com/httpstatuscodes.html).

## REST

If protocols are our transport for moving around on the internet, URLS are the addresses on our map. We've come to expect certain conventions from addresses though, for example we generally write house number, then street, then town. If someone decided to stick their postcode in the middle it would be very confusing, so we all try to follow the same convention as far as possible. We try to apply similar conventions to web addresses, although there are many more competing conventions here.

One such convention is **REST**, or **Re**presentational **S**tate **T**ransfer. If a resource is described as **RESTful** we mean that it follows the REST convention. There are a few rules around REST which will become more relevant as we move through the course, but one which is immediately obvious is the way in which the URLs in a RESTful resource are structured.

Consider this url:

```
www.bbc.co.uk/news/scotland
```

We can get a good idea just from reading the URL what we will find when we go to this page. We could also make an educated guess at what we would need to change to read news from a different part of the UK:

```
www.bbc.co.uk/news/wales
```

To find a specific story we only need to add one piece of information:

```
www.bbc.co.uk/news/scotland/story-id-number
```

By following this naming convention we make it much easier not only for users to navigate our applications but aslo for them to add or edit information. There is a standardised template (illustrated [in this article](https://medium.com/@shubhangirajagrawal/the-7-restful-routes-a8e84201f206)) for developers to build a RESTful application, although there is no obligation to stick to it or implement it fully. As with many aspects of development there is no single "correct" way of structuring a web server and REST may not always be the best solution in a given situation.