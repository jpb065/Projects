using System;
using System.IO.Ports;
using System.Device.Gpio;

class DoorLockSystem
{
    private const int LockPin = 17;
    private GpioController gpioController;
    private SerialPort huskyLensPort;
    private int[] authorizedFaceIds = { 1, 2 };

    public DoorLockSystem()
    {
        gpioController = new GpioController();
        gpioController.OpenPin(LockPin, PinMode.Output);
        LockDoor();

        huskyLensPort = new SerialPort("COM3", 9600);
        huskyLensPort.DataReceived += new SerialDataReceivedEventHandler(DataReceivedHandler);
        huskyLensPort.Open();
    }

    private void LockDoor()
    {
        gpioController.Write(LockPin, PinValue.Low);
    }

    private void UnlockDoor()
    {
        gpioController.Write(LockPin, PinValue.High);
        System.Threading.Thread.Sleep(5000);
        LockDoor();
    }

    private void DataReceivedHandler(object sender, SerialDataReceivedEventArgs e)
    {
        string data = huskyLensPort.ReadExisting();
        int recognizedFaceId;
        
        if (int.TryParse(data, out recognizedFaceId))
        {
            if (IsAuthorizedPerson(recognizedFaceId))
            {
                UnlockDoor();
            }
        }
    }

    private bool IsAuthorizedPerson(int faceId)
    {
        foreach (int id in authorizedFaceIds)
        {
            if (faceId == id)
            {
                return true;
            }
        }
        return false;
    }

    static void Main(string[] args)
    {
        DoorLockSystem doorLockSystem = new DoorLockSystem();
        while (true) { }  // Keep the program running
    }
}
