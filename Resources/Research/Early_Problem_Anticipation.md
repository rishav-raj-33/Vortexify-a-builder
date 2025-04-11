![Approved by ChatGPT](https://img.shields.io/badge/Approved%20by-ChatGPT-brightgreen?style=for-the-badge&logo=openai)

# Vortexify: Early Planning, Anticipated Challenges & Solutions

Before the first line of code was written, we recognized that developing a multi-module, team-driven project could invite real-world challenges — both in development and deployment. This document outlines the problems we anticipated and the strategies we implemented in advance to prevent or solve them effectively. The vision was always to handle this project like a production-grade industry system, and this preparation reflects that intent.

---

## 1. Anticipated Challenge: Merge Conflicts Across Modules

When multiple teammates work on different modules within the same codebase, merge conflicts become inevitable — especially when directories overlap or file structures are not clearly separated.

**Planned Solution:**  
We avoided this by keeping the `main` branch empty of module code and creating independent Git branches for each module (e.g., `skin-module`, `brain-module`). Each teammate worked in their respective branch, maintaining clean and conflict-free codebases. Only after a module's complete development and testing was it scheduled for merging into the `main` branch.

---

## 2. Anticipated Challenge: Linking Separate Codebases to GitHub Branches

Modules may originate from completely different folders or development environments, making it difficult to track them under one repository cleanly.

**Planned Solution:**  
Each module was treated as a standalone Git project that pushed to its corresponding branch in the Vortexify repository. This allowed us to isolate work cleanly while maintaining centralized collaboration on GitHub.

---

## 3. Anticipated Challenge: Teammates’ Lack of Git and Project Flow Knowledge

Not every team member had experience with Git, branching, or professional workflows.

**Planned Solution:**  
To ensure no one felt lost, we created detailed markdown documentation: a branching strategy guide, project roadmap and teammate workflow guide. These docs made expectations clear and helped everyone work autonomously.

---

## 4. Anticipated Challenge: Lack of Documentation Clarity

Previous projects lacked meaningful documentation — making it hard to understand functionality or replicate success.

**Planned Solution:**  
We decided from the start that every module and concept would be documented. From architecture to deployment planning and contributor tracking — every `.md` file was treated as a vital communication layer of the project.

---

## 5. Anticipated Challenge: Deployment Conflicts on Shared Docker Host

We knew deploying multiple Spring Boot services to the same VMware-based Docker host would result in port conflicts, as Spring Boot defaults to port 8080.

**Planned Solution:**  
Since modifying internal Dockerfiles wasn’t an option, we mapped different external ports to internal container ports using Docker’s run-time port mapping. This let each service run independently without clashing.

---

## 6. Anticipated Challenge: Post-Integration Testing

After module merges, the risk of incompatible integration rises. Without proper final validation, bugs could surface late.

**Planned Solution:**  
We committed to doing a complete round of final testing **after every module integration** with the `main` branch. This ensures seamless functionality across all parts of the system and avoids last-minute surprises.

---



## ✅ Final Note

These weren't problems we stumbled upon — they were roadblocks we *planned around*. This vision-first strategy sets Vortexify apart as a production-ready, maintainable, and scalable project. After a module is fully developed and tested, it will be merged into the `main` branch, followed by integration testing to ensure end-to-end stability.

---
