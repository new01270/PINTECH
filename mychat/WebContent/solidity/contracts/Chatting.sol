pragma solidity >=0.6.0 <0.8.0;

contract Chatting {
    address payable creator;
    
    string name;
    string message;
    uint timeStamp;

	constructor() public {
	    
	}

    event chat (string name,
        string message,
        uint timeStamp);

    function setChat(string memory _name, string memory _msg) public {
        name = _name;
        message = _msg;
        timeStamp = now;	// 초단위만 가짐
        emit chat(name, message, timeStamp);	//emit: 이벤트 호출
    }

    function getChat() public view returns(string memory, string memory, uint) {
        return (name, message, timeStamp);
    }
}


