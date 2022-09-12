import React, { useCallback, useState } from 'react';

function App() {
	const [boardID, setBoardID] = useState(null);
	const [message, setMessage] = useState(null);

	const handleSetBoardID = useCallback(e => setBoardID(e.target.value), [])

	const handleSubmit = useCallback(async e => {
		let response, data;

		try {
			e.preventDefault();

			response = await fetch(`http://localhost:8080/update?board=${boardID}`);
			data = await response.json();
		} catch (error) {
			console.error(error);
		} finally {
			setMessage(data.message);
		}
	}, [boardID]);

	return (
		<form onSubmit={handleSubmit}>
			<input type={'text'} name={'boardID'} placeholder={'Board ID'} value={boardID} onChange={handleSetBoardID} />
			<button type={'submit'}>Update</button>
			{ message && <p>{ message }</p>}
		</form>
	);
}

export default App;