import BusService from '@/services/BusService'; // Update the import path as needed
import axios from 'axios';

// Mock Axios
jest.mock('axios');

describe('BusService', () => {
  const testBuses = [
    { id: 1, name: 'Bus 1' },
    { id: 2, name: 'Bus 2' },
  ];
  const busId = 1;
  const updatedBus = { id: 1, name: 'Updated Bus 1' };

  it('fetches a list of buses', async () => {
    // Mock a successful GET request
    axios.get.mockResolvedValue({ data: testBuses });

    const response = await BusService.getbuses();

    expect(axios.get).toHaveBeenCalledWith('http://localhost:8090/bus');
    expect(response.data).toEqual(testBuses);
  });

  it('fetches a bus by ID', async () => {
    // Mock a successful GET request
    axios.get.mockResolvedValue({ data: testBuses[0] });

    const response = await BusService.getBusById(busId);

    expect(axios.get).toHaveBeenCalledWith(`http://localhost:8090/bus/${busId}`);
    expect(response.data).toEqual(testBuses[0]);
  });

  it('updates a bus', async () => {
    // Mock a successful PUT request
    axios.put.mockResolvedValue({ data: updatedBus });

    const response = await BusService.updateBus(updatedBus);

    expect(axios.put).toHaveBeenCalledWith('http://localhost:8090/bus', updatedBus);
    expect(response.data).toEqual(updatedBus);
  });

  it('deletes a bus by ID', async () => {
    // Mock a successful DELETE request
    axios.delete.mockResolvedValue({ data: 'Bus deleted' });

    const response = await BusService.deleteBus(busId);

    expect(axios.delete).toHaveBeenCalledWith(`http://localhost:8090/bus/${busId}`);
    expect(response.data).toBe('Bus deleted');
  });
});
