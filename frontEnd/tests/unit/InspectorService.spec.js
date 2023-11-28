import InspectorService from '@/services/InspectorService'; // Adjust the import path as needed

// Mock Axios for API calls
jest.mock('axios');

describe('InspectorService', () => {
  // Mock response data for successful and error responses
  const successfulResponse = { data: 'Sample response data' };
  const errorResponse = new Error('Sample error message');

  it('fetches a list of inspectors', async () => {
    // Mock a successful API call
    axios.get.mockResolvedValue(successfulResponse);

    // Call the service method and capture the result
    const response = await InspectorService.getInspector();

    // Check if the API call was made
    expect(axios.get).toHaveBeenCalledWith('http://localhost:8090/inspector');

    // Check if the response matches the expected data
    expect(response).toEqual(successfulResponse);
  });

  it('fetches an inspector by ID', async () => {
    const inspectorId = 123; // Replace with a valid inspector ID

    // Mock a successful API call
    axios.get.mockResolvedValue(successfulResponse);

    // Call the service method with the inspector ID and capture the result
    const response = await InspectorService.getInspectorById(inspectorId);

    // Check if the API call was made with the correct URL
    expect(axios.get).toHaveBeenCalledWith(`http://localhost:8090/inspector/${inspectorId}`);

    // Check if the response matches the expected data
    expect(response).toEqual(successfulResponse);
  });

  it('updates an inspector', async () => {
    const inspectorData = { id: 123, name: 'John Doe' }; // Replace with valid inspector data

    // Mock a successful API call
    axios.put.mockResolvedValue(successfulResponse);

    // Call the service method with inspector data and capture the result
    const response = await InspectorService.updateInspector(inspectorData);

    // Check if the API call was made with the correct URL and data
    expect(axios.put).toHaveBeenCalledWith('http://localhost:8090/inspector', inspectorData);

    // Check if the response matches the expected data
    expect(response).toEqual(successfulResponse);
  });

  it('deletes an inspector', async () => {
    const inspectorId = 123; // Replace with a valid inspector ID

    // Mock a successful API call
    axios.delete.mockResolvedValue(successfulResponse);

    // Call the service method with the inspector ID and capture the result
    const response = await InspectorService.DeleteInpector(inspectorId);

    // Check if the API call was made with the correct URL
    expect(axios.delete).toHaveBeenCalledWith(`http://localhost:8090/inspector/${inspectorId}`);

    // Check if the response matches the expected data
    expect(response).toEqual(successfulResponse);
  });

  it('handles errors gracefully', async () => {
    // Mock an API call that results in an error
    axios.get.mockRejectedValue(errorResponse);

    try {
      // Call the service method that is expected to result in an error
      await InspectorService.getInspector();
    } catch (error) {
      // Check if the error message matches the expected error message
      expect(error).toEqual(errorResponse);
    }
  });
});
