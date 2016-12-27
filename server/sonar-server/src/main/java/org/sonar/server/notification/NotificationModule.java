/*
 * SonarQube
 * Copyright (C) 2009-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package org.sonar.server.notification;

import org.sonar.api.config.EmailSettings;
import org.sonar.core.platform.Module;
import org.sonar.server.email.ws.EmailsWsModule;
import org.sonar.server.notification.email.AlertsEmailTemplate;
import org.sonar.server.notification.email.EmailNotificationChannel;
import org.sonar.server.notification.ws.AddAction;
import org.sonar.server.notification.ws.NotificationsWs;

public class NotificationModule extends Module {
  @Override
  protected void configureModule() {
    add(
      EmailSettings.class,
      NotificationService.class,
      NotificationCenter.class,
      NotificationUpdater.class,
      DefaultNotificationManager.class,
      EmailsWsModule.class,
      NotificationDaemon.class,
      AlertsEmailTemplate.class,
      EmailNotificationChannel.class,
      // WS
      NotificationsWs.class,
      AddAction.class);
  }
}