#!/bin/bash

# Range of ports to check (customize if needed)
START_PORT=1024
END_PORT=65535

# Function to find one available port
find_port() {
  for ((port=$START_PORT; port<=$END_PORT; port++)); do
    # Check if the port is not in use (both IPv4 and IPv6)
    if ! ss -tuln | grep -qE ":$port\s"; then
      echo "$port"
      return 0
    fi
  done

  # If no port is available
  echo "No available port found in range $START_PORT to $END_PORT"
  return 1
}

# Run the function
find_port
